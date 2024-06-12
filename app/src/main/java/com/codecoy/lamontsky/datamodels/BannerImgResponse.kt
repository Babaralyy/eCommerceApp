package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class BannerImgResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: ArrayList<BannerImgData> = arrayListOf()
) {
}