package com.example.lib.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_IN_SECONDS=60

object RetrofitHelper {
    val baseUrl = "https://api.imgur.com/3/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
                    .authenticator(TokenAuthenticator())
                    .build()
            )
            .build()
    }
}
