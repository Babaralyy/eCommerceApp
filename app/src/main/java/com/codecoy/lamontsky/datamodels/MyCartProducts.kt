package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

class MyCartProducts (
    @SerializedName("user_id"           ) var userId          : Int?                 = null,
    @SerializedName("order_desc"        ) var orderDesc       : String?              = null,
    @SerializedName("total_items"       ) var totalItems      : String?              = null,
    @SerializedName("total_price_order" ) var totalPriceOrder : Double?                 = null,
    @SerializedName("order_list"        ) var orderList       : List<NumberOfProducts> = arrayListOf()
){
}