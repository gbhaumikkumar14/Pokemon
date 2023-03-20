package com.bhaumikghodasara.data.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            200 -> {
                Log.d(NETWORK_TAG, response.toString())
            }
            400 -> {
                Log.d(NETWORK_TAG, response.toString())
            }
            else -> {
                Log.d(NETWORK_TAG, response.toString())
            }
        }
        return response
    }

    companion object {
        private const val NETWORK_TAG = "NetworkModule"
    }
}