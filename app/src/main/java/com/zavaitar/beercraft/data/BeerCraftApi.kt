package com.zavaitar.beercraft.data

import retrofit2.Response
import retrofit2.http.GET

interface BeerCraftApi {

    @GET("/v2/beers")
    suspend fun getAllBeerList(): Response<List<Beer>>
}