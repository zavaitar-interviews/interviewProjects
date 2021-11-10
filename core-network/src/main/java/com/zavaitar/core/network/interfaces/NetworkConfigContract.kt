package com.zavaitar.core.network.interfaces

import okhttp3.Interceptor

interface NetworkConfigContract {
    val interceptors: List<Interceptor>
}
