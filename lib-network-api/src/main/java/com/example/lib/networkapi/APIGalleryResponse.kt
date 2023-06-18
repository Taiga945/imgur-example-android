package com.example.lib.networkapi

import com.google.gson.annotations.SerializedName

data class APIGalleryResponse(
    @SerializedName("data")
    val data: List<APIGalleryData>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("status")
    val status: Int
)
