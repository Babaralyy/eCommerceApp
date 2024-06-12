package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class SubCatResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: List<SubCatData> = arrayListOf()
) {
}