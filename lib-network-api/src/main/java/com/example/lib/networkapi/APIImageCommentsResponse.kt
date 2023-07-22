package com.example.lib.networkapi

import com.google.gson.annotations.SerializedName

data class APIImageCommentsResponse (
    @SerializedName("data")
    val data: List<APIImageComment>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("status")
    val status: Int
)