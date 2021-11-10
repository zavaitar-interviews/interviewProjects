package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.MainCoroutineRule
import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.domain.BeerCraftUseCase
import com.zavaitar.core.network.util.ResponseCallback
import io.mockk.*
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class BeerListViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK
    lateinit var useCase: BeerCraftUseCase

    private lateinit var viewModel: BeerListViewModel
    private val beerCraftApiResponseSlot = slot<ResponseCallback<List<Beer>>>()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = BeerListViewModel(mainCoroutineRule.testDispatcher, useCase)
    }

    @Test
    fun `verify DefaultState is default state`() {
        val defaultState = viewModel.defaultState
        assertEquals(BeerListStatus.DefaultState, defaultState.status)
    }

    @Test
    fun `when SelectedBeer intent received then verify ShowBeerDetailsScreen effect`() {

        runBlockingTest {
            launch(mainCoroutineRule.testDispatcher) {
                viewModel.effects.filterNotNull().collect {
                    assertTrue(it is BeerListEffect.ShowBeerDetailsScreen)
                    this.cancel()
                }
            }

            viewModel.intents.send(BeerListIntent.SelectedBeer(mockk()))
        }
    }

    @Test
    fun `when FetchBeerData intent received and invoke callBeerDataApi and onSuccess get called`() {

        runBlockingTest {

            every {
                runBlockingTest {
                    useCase.invoke(capture(beerCraftApiResponseSlot))
                }
            } answers {
                beerCraftApiResponseSlot.captured.onSuccess(listOf())
            }

            launch(mainCoroutineRule.testDispatcher) {
                viewModel.effects.filterNotNull().collect {
                    assertTrue(it is BeerListEffect.PopulateBeerList)
                    this.cancel()
                }
            }

            viewModel.intents.send(BeerListIntent.FetchBeerData)

            verify(exactly = 1) { runBlockingTest { useCase.invoke(any()) } }
            assertEquals(viewModel.state.value.status, BeerListStatus.ProgressLoaded)
        }
    }

    @Test
    fun `when FetchBeerData intent received and invoke callBeerDataApi and onError get called`() {
        runBlockingTest {
            every {
                runBlockingTest {
                    useCase.invoke(capture(beerCraftApiResponseSlot))
                }
            } answers {
                beerCraftApiResponseSlot.captured.onError(mockk())
            }

            viewModel.intents.send(BeerListIntent.FetchBeerData)

            verify(exactly = 1) { runBlockingTest { useCase.invoke(any()) } }
            assertEquals(viewModel.state.value.status, BeerListStatus.ProgressLoaded)
        }
    }
}
