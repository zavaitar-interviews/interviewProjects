package com.zavaitar.beercraft.mvi.beerDetails

import com.zavaitar.beercraft.core.architecture.interfaces.MviState

data class BeerDetailsState(val status: BeerDetailsStatus) : MviState

sealed class BeerDetailsStatus {
    object DefaultState : BeerDetailsStatus()
}