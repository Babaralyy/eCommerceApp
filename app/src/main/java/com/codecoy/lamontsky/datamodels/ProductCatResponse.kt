package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class ProductCatResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: List<ProductCatData> = arrayListOf()
)