package com.example.lib.network

import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetGalleryIT {
    @Test
    fun sendRequest() {
        val imgurService= RetrofitHelper.getInstance().create(ImgurService::class.java)
        val response= runBlocking { imgurService.getGallery() }
        assert(response.status==200)
    }
}