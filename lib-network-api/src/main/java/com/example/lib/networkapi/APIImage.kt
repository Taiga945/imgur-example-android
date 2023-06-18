package com.example.lib.networkapi

import com.google.gson.annotations.SerializedName

data class APIImage(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("datetime")
    val datetime: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("animated")
    val animated: Boolean?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("views")
    val views: Int?,
    @SerializedName("bandwidth")
    val bandwidth: Long?,
    @SerializedName("vote")
    val vote: String?,
    @SerializedName("favorite")
    val favorite: Boolean?,
    @SerializedName("nsfw")
    val nsfw: String?,
    @SerializedName("section")
    val section: String?,
    @SerializedName("account_url")
    val accountUrl: String?,
    @SerializedName("account_id")
    val accountId: String?,
    @SerializedName("is_ad")
    val isAd: Boolean?,
    @SerializedName("in_most_viral")
    val inMostViral: Boolean?,
    @SerializedName("has_sound")
    val hasSound: Boolean?,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("ad_type")
    val adType: Int?,
    @SerializedName("ad_url")
    val adUrl: String?,
    @SerializedName("edited")
    val edited: String?,
    @SerializedName("in_gallery")
    val inGallery: Boolean?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("mp4_size")
    val mp4Size: Int?,
    @SerializedName("mp4")
    val mp4: String?,
    @SerializedName("gifv")
    val gifv: String?,
    @SerializedName("hls")
    val hls: String?,
    @SerializedName("processing")
    val processing: APIImageProcessing?,
    @SerializedName("comment_count")
    val commentCount: String?,
    @SerializedName("favorite_count")
    val favoriteCount: String?,
    @SerializedName("ups")
    val ups: String?,
    @SerializedName("downs")
    val downs: String?,
    @SerializedName("points")
    val points: String?,
    @SerializedName("score")
    val score: String?
)
