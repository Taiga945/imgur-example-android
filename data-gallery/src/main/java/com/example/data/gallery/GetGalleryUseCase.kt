package com.example.data.gallery

import com.example.lib.network.ImgurRepository

class GetGalleryUseCase {
    suspend fun sendRequest(): GalleryResponse {
        val response = ImgurRepository().getGallery()

        val images = response.data.mapNotNull { dataItem ->
            dataItem.images?.getOrNull(0)?.link?.takeIf {
                it.endsWith(".jpg") || it.endsWith(".png")
            }
        }

        return GalleryResponse(images)
    }
}