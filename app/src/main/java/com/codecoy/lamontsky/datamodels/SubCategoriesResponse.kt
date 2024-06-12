package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

class SubCategoriesResponse(

    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: MutableList<SubCategoriesData> = arrayListOf()

)