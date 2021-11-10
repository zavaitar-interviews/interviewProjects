package com.zavaitar.core.network.di

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zavaitar.core.network.NetworkConfig
import com.zavaitar.core.network.interceptors.NoConnectionInterceptor
import com.zavaitar.core.network.interfaces.NetworkConfigContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private fun getBaseUrl() = BASE_URL

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        networkConfigContract: NetworkConfigContract
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)

            networkConfigContract.interceptors.forEach { addInterceptor(it) }

        }.build()
    }

    @Provides
    @Singleton
    internal fun networkApiConfig(@ApplicationContext context: Context): NetworkConfigContract = NetworkConfig(context)

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setDateFormat(DateFormat.LONG)
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .setVersion(1.0)
            .create()
    }

    private companion object {
        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
        const val BASE_URL = "https://api.punkapi.com"
    }
}
