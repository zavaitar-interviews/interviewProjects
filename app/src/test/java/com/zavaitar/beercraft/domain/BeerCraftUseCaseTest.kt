package com.zavaitar.beercraft.domain

import com.zavaitar.beercraft.data.Beer
import com.zavaitar.beercraft.data.BeerCraftApi
import com.zavaitar.core.network.util.ResponseCallback
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class BeerCraftUseCaseTest {

    @MockK
    lateinit var beerCraftApi: BeerCraftApi

    @MockK(relaxed = true)
    lateinit var responseCallback: ResponseCallback<List<Beer>>

    private lateinit var useCase: BeerCraftUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        useCase = BeerCraftUseCaseImpl(beerCraftApi)
    }

    @Test
    fun `verify callback onSuccess called when API returns success`() {
        runBlocking {
            val response = listOf<Beer>()
            coEvery { beerCraftApi.getAllBeerList() } returns Response.success(response)

            useCase.invoke(responseCallback)
            verify { responseCallback.onSuccess(response) }
        }
    }

    @Test
    fun `verify callback onError called when API returns Error`() {
        runBlocking {
            val response = mockk<ResponseBody>(relaxed = true)
            coEvery { beerCraftApi.getAllBeerList() } returns Response.error(401, response)

            useCase.invoke(responseCallback)
            verify { responseCallback.onError(any()) }
        }
    }
}
