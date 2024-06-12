package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("User     Data") var signInData: SignInData? = SignInData()
)