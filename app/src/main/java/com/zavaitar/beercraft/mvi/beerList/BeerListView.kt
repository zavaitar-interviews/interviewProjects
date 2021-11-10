package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.core.architecture.interfaces.MviView
import com.zavaitar.beercraft.data.Beer

interface BeerListView : MviView {
    fun populateBeerList(beerList: List<Beer>?)
    fun showBeerDetailsPage(beer: Beer)
    fun loadProgressView()
    fun hideProgressView()
}
