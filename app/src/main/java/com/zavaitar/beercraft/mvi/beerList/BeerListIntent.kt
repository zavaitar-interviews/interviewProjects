package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.core.architecture.interfaces.MviIntent
import com.zavaitar.beercraft.data.Beer

sealed class BeerListIntent : MviIntent {
    object FetchBeerData : BeerListIntent()
    data class SelectedBeer(val beer: Beer) : BeerListIntent()
}
