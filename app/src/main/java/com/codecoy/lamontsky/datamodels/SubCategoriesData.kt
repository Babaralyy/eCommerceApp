package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

class SubCategoriesData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("cat_id") var catId: String? = null,
    @SerializedName("subcat_id") var subcatId: String? = null,
    @SerializedName("product_name") var productName: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("price") var price: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("Product_images") var ProductImages: List<ProductImages> = arrayListOf()
)