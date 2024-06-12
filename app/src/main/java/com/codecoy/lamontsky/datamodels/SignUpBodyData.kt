package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class SignUpBodyData(
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("dob") var dob: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("password") var password: String? = null

)
