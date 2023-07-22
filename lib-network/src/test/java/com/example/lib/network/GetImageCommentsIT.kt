package com.example.lib.network

import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetImageCommentsIT {
    @Test
    fun sendRequest() {
        val imgurService= RetrofitHelper.getInstance().create(ImgurService::class.java)
        val response= runBlocking { imgurService.getImageComments("l6aR6Fb") }
        assert(response.status==200)
    }
}
