package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class ProductImages(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("product_id") var productId: String? = null,
    @SerializedName("product_img") var productImg: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null
)