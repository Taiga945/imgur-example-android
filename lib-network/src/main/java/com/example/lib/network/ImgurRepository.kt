package com.example.lib.network

import com.example.lib.networkapi.APIGalleryResponse
import com.example.lib.networkapi.APIImageCommentsResponse

class ImgurRepository {
    suspend fun getGallery() : APIGalleryResponse {
        val imgurService = RetrofitHelper.getInstance().create(ImgurService::class.java)
        return imgurService.getGallery()
    }

    suspend fun getImageComments(id: String) : APIImageCommentsResponse {
        val imgurService = RetrofitHelper.getInstance().create(ImgurService::class.java)
        return imgurService.getImageComments(id)
    }
}