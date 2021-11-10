package com.zavaitar.beercraft.mvi.beerDetails

import com.zavaitar.beercraft.MainCoroutineRule
import io.mockk.MockKAnnotations
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BeerDetailsViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: BeerDetailsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = BeerDetailsViewModel()
    }

    @Test
    fun `verify DefaultState is default state`() {
        val defaultState = viewModel.defaultState
        assertEquals(BeerDetailsStatus.DefaultState, defaultState.status)
    }
}
