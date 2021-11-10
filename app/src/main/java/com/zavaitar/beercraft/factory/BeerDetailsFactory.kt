package com.zavaitar.beercraft.factory

import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsRenderer
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsViewModel
import com.zavaitar.beercraft.presentation.BeerDetailsFragment
import javax.inject.Provider

class BeerDetailsFactory constructor(private val viewModelProvider: Provider<BeerDetailsViewModel>) {

    fun getViewModel(): BeerDetailsViewModel = viewModelProvider.get()

    fun getRenderer(): BeerDetailsRenderer = BeerDetailsRenderer()

    fun getView(fragment: BeerDetailsFragment) = fragment
}

