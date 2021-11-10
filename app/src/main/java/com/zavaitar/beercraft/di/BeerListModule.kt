package com.zavaitar.beercraft.di

import com.zavaitar.beercraft.domain.BeerCraftUseCase
import com.zavaitar.beercraft.factory.BeerListFactory
import com.zavaitar.beercraft.mvi.beerList.BeerListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Provider

@InstallIn(SingletonComponent::class)
@Module
class BeerListModule {

    @Provides
    fun provideBeerListViewModel(
        dispatcher: CoroutineDispatcher,
        beerCraftUseCase: BeerCraftUseCase
    ): BeerListViewModel = BeerListViewModel(dispatcher, beerCraftUseCase)

    @Provides
    fun provideBeerListFactory(viewModelProvider: Provider<BeerListViewModel>): BeerListFactory =
        BeerListFactory(viewModelProvider)
}