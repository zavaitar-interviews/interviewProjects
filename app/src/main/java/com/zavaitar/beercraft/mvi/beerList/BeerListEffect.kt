package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.core.architecture.interfaces.MviEffect
import com.zavaitar.beercraft.data.Beer

sealed class BeerListEffect : MviEffect {
    data class PopulateBeerList(val beerList: List<Beer>?) : BeerListEffect()
    data class ShowBeerDetailsScreen(val beer: Beer) : BeerListEffect()
}
