package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

class NumberOfProducts (  @SerializedName("product_id"           ) var productId          : Int?    = null,
                          @SerializedName("total_products"       ) var totalProducts      : String? = null,
                          @SerializedName("total_price_products" ) var totalPriceProducts : String? = null)