package com.zavaitar.core.network.util

interface ResponseCallback<T> {
    fun onSuccess(response: T?)
    fun onError(error: Throwable?)
}
