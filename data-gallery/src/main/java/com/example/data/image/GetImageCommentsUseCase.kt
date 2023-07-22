package com.example.data.image

import com.example.lib.network.ImgurRepository

class GetImageCommentsUseCase {
    suspend fun getImages(id: String): ImageCommentsResponse {
        val response = ImgurRepository().getImageComments(id)

        val images = response.data.map { dataItem ->
            ImageComment(dataItem.imageId, dataItem.comment, dataItem.ups, dataItem.downs)
        }

        return ImageCommentsResponse(images)
    }
}