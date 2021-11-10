package com.zavaitar.beercraft.mvi.beerDetails

import com.zavaitar.beercraft.core.architecture.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(): MviViewModel<BeerDetailsState, BeerDetailsIntent, BeerDetailsEffect>() {

    override val defaultState: BeerDetailsState =
        BeerDetailsState(BeerDetailsStatus.DefaultState)

    override fun receiveIntent(intent: BeerDetailsIntent) {
        // No implementation needed
    }
}
