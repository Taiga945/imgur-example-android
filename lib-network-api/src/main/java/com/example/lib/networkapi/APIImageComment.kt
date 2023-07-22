package com.example.lib.networkapi

import com.google.gson.annotations.SerializedName

data class APIImageComment (
    @SerializedName("image_id")
    val imageId: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("ups")
    val ups: Int,
    @SerializedName("downs")
    val downs: Int
)