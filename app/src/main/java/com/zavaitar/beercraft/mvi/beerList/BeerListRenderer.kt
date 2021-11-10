package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.core.architecture.interfaces.MviRenderer

class BeerListRenderer : MviRenderer<BeerListState, BeerListView, BeerListEffect> {

    override fun render(state: BeerListState, view: BeerListView) {
        when (state.status) {
            is BeerListStatus.ProgressLoading -> view.loadProgressView()
            is BeerListStatus.ProgressLoaded -> view.hideProgressView()
            else -> return
        }
    }

    override fun react(effect: BeerListEffect, view: BeerListView) {
        when (effect) {
            is BeerListEffect.PopulateBeerList -> view.populateBeerList(effect.beerList)
            is BeerListEffect.ShowBeerDetailsScreen -> view.showBeerDetailsPage(effect.beer)
        }
    }
}
