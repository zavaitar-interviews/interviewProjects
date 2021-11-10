package com.zavaitar.beercraft.mvi.beerList

import androidx.lifecycle.viewModelScope
import com.zavaitar.beercraft.core.architecture.MviViewModel
import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.domain.BeerCraftUseCase
import com.zavaitar.core.network.util.ResponseCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val beerListUseCase: BeerCraftUseCase,
) : MviViewModel<BeerListState, BeerListIntent, BeerListEffect>() {

    override val defaultState: BeerListState = BeerListState(BeerListStatus.DefaultState)
    override var coroutinesDispatcher: CoroutineDispatcher = dispatcher

    override fun receiveIntent(intent: BeerListIntent) {
        when (intent) {
            is BeerListIntent.FetchBeerData -> callBeerDataApi()
            is BeerListIntent.SelectedBeer ->
                postEffect(BeerListEffect.ShowBeerDetailsScreen(intent.beer))
        }
    }

    private fun callBeerDataApi() {
        viewModelScope.launch(dispatcher) {
            reduceState { copy(status = BeerListStatus.ProgressLoading) }
            beerListUseCase.invoke(
                object : ResponseCallback<List<Beer>> {

                    override fun onSuccess(response: List<Beer>?) {
                        reduceState { copy(status = BeerListStatus.ProgressLoaded) }
                        postEffect(BeerListEffect.PopulateBeerList(response))
                    }

                    override fun onError(error: Throwable?) {
                        reduceState { copy(status = BeerListStatus.ProgressLoaded) }
                    }
                }
            )
        }
    }
}
