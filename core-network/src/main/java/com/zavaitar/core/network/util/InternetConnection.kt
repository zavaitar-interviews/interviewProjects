package com.zavaitar.core.network.util

import android.content.Context
import android.net.ConnectivityManager
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object InternetConnection {

    private fun preAndroidMInternetCheck(
        connectivityManager: ConnectivityManager
    ): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null) {
            return (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
        }
        return false
    }

    fun isConnectionOn(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager

        return  preAndroidMInternetCheck(connectivityManager)

    }

    fun isInternetAvailable(): Boolean {
        return try {
            val timeoutMs = 3000
            val sock = Socket()
            val sockAddress = InetSocketAddress(INTERNET_HOST, INTERNET_PORT)
            sock.connect(sockAddress, timeoutMs)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }
    }

    private const val INTERNET_HOST = "8.8.8.8"
    private const val INTERNET_PORT = 53
}