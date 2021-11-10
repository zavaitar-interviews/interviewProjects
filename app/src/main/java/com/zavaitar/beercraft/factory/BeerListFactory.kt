package com.zavaitar.beercraft.factory

import com.zavaitar.beercraft.mvi.beerList.BeerListRenderer
import com.zavaitar.beercraft.mvi.beerList.BeerListViewModel
import com.zavaitar.beercraft.presentation.BeerListFragment
import javax.inject.Provider

class BeerListFactory constructor(private val viewModelProvider: Provider<BeerListViewModel>) {

    fun getViewModel(): BeerListViewModel = viewModelProvider.get()

    fun getRenderer(): BeerListRenderer = BeerListRenderer()

    fun getView(fragment: BeerListFragment) = fragment
}

