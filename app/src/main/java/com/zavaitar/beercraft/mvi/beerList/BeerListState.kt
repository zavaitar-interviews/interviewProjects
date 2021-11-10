package com.zavaitar.beercraft.mvi.beerList

import com.zavaitar.beercraft.core.architecture.interfaces.MviState

data class BeerListState(val status: BeerListStatus) : MviState

sealed class BeerListStatus {
    object DefaultState : BeerListStatus()
    object ProgressLoading : BeerListStatus()
    object ProgressLoaded : BeerListStatus()
}
