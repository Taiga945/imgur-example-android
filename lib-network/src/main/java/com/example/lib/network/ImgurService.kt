package com.example.lib.network

import com.example.lib.networkapi.APIGalleryResponse
import retrofit2.http.GET

interface ImgurService {
    @GET("gallery/hot/viral/0?location=desktophome&realtimeResults=false&showViral=true")
    suspend fun getGallery(): APIGalleryResponse
}
