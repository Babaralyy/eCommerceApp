package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class BannerImgData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("banner_img") var bannerImg: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null
)