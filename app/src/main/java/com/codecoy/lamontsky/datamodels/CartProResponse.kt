package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

class CartProResponse(@SerializedName("status"  ) var status  : Boolean? = null,
                      @SerializedName("message" ) var message : String?  = null)