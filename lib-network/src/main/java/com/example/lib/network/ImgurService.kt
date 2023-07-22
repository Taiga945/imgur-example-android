package com.example.lib.network

import com.example.lib.networkapi.APIGalleryResponse
import com.example.lib.networkapi.APIImageCommentsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ImgurService {
    @GET("gallery/hot/viral/0?location=desktophome&realtimeResults=false&showViral=true")
    suspend fun getGallery(): APIGalleryResponse

    @GET("gallery/{id}/comments/top")
    suspend fun getImageComments(@Path("id") id: String): APIImageCommentsResponse
}
