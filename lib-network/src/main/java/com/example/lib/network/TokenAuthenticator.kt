package com.example.lib.network

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

private const val HEADER_AUTHORIZATION = "Authorization"

class TokenAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val updatedToken = "Bearer 296174522687d4554a0cad8076cf7d836cbd62bc" //TODO add refreshing token
        return response.request().newBuilder()
            .header(HEADER_AUTHORIZATION, updatedToken)
            .build()
    }
}
