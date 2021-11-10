package com.zavaitar.beercraft.di

import com.zavaitar.beercraft.data.BeerCraftApi
import com.zavaitar.beercraft.domain.BeerCraftUseCase
import com.zavaitar.beercraft.domain.BeerCraftUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Provider

@InstallIn(SingletonComponent::class)
@Module
class BeerCraftFeatureModule {

    @Provides
    fun coroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideBeerCraftUseCase(beerCraftApi: BeerCraftApi): BeerCraftUseCase =
        BeerCraftUseCaseImpl(beerCraftApi)

    @Provides
    fun providesBeerCraftApi(retrofit: Retrofit):BeerCraftApi =
        retrofit.create(BeerCraftApi::class.java)
}
