package com.example.data.gallery

import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetGalleryUseCaseIT {
    @Test
    fun getGallery() {
        val result = runBlocking { GetGalleryUseCase().sendRequest() }
        assert(result.images.isNotEmpty())
    }
}