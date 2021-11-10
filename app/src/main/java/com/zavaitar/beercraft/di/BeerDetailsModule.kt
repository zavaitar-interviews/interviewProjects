package com.zavaitar.beercraft.di

import com.zavaitar.beercraft.factory.BeerDetailsFactory
import com.zavaitar.beercraft.mvi.beerDetails.BeerDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider

@InstallIn(SingletonComponent::class)
@Module
class BeerDetailsModule {

    @Provides
    fun provideBeerDetailsViewModel(): BeerDetailsViewModel =
        BeerDetailsViewModel()

    @Provides
    fun provideBeerDetailsFactory(viewModelProvider: Provider<BeerDetailsViewModel>):
            BeerDetailsFactory = BeerDetailsFactory(viewModelProvider)
}