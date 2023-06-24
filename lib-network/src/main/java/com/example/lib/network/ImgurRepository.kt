package com.example.lib.network

import com.example.lib.networkapi.APIGalleryResponse

class ImgurRepository {
    suspend fun getGallery() : APIGalleryResponse {
        val imgurService = RetrofitHelper.getInstance().create(ImgurService::class.java)
        return imgurService.getGallery()
    }
}