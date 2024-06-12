package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class ProductCatData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("category_name") var categoryName: String? = null,
    @SerializedName("img") var img: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null
)