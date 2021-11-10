package com.zavaitar.core.network.exceptions

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No network available, Please check your internet connection"
}
