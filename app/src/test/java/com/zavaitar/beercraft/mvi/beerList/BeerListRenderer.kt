package com.zavaitar.beercraft.mvi.beerList

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BeerListRendererTest {

    lateinit var renderer: BeerListRenderer

    @MockK
    lateinit var view: BeerListView

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        renderer = BeerListRenderer()
    }

    @Test
    fun `verify loadProgressView when BeerListStatus ProgressLoading`() {
        renderer.render(BeerListState(BeerListStatus.ProgressLoading), view)
        verify { view.loadProgressView() }
    }

    @Test
    fun `verify hideProgressView when BeerListStatus ProgressLoaded`() {
        renderer.render(BeerListState(BeerListStatus.ProgressLoaded), view)
        verify { view.hideProgressView() }
    }

    @Test
    fun `verify populateBeerList when BeerListEffect PopulateBeerList`() {
        renderer.react(BeerListEffect.PopulateBeerList(listOf()), view)
        verify { view.populateBeerList(listOf()) }
    }

    @Test
    fun `verify showBeerDetailsPage when BeerListEffect ShowBeerDetailsScreen`() {
        renderer.react(BeerListEffect.ShowBeerDetailsScreen(mockk()), view)
        verify { view.showBeerDetailsPage(any()) }
    }
}