package com.zavaitar.beercraft.domain

import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.data.BeerCraftApi
import com.zavaitar.core.network.util.ResponseCallback
import javax.inject.Inject

interface BeerCraftUseCase {
    suspend fun invoke(responseCallback: ResponseCallback<List<Beer>>)
}

internal class BeerCraftUseCaseImpl @Inject constructor(private val beerApi: BeerCraftApi) :
    BeerCraftUseCase {

    override suspend fun invoke(responseCallback: ResponseCallback<List<Beer>>) {
        val response = beerApi.getAllBeerList()
        when {
            response.isSuccessful -> responseCallback.onSuccess(response.body())
            else -> responseCallback.onError(IllegalStateException("Error from Service"))
        }
    }
}
