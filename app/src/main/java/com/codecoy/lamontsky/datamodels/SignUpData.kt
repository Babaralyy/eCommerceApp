package com.codecoy.lamontsky.datamodels

import com.google.gson.annotations.SerializedName

data class SignUpData(
    @SerializedName("id"                ) var id              : Int?    = null,
    @SerializedName("profile_img"       ) var profileImg      : String? = null,
    @SerializedName("name"              ) var name            : String? = null,
    @SerializedName("username"          ) var username        : String? = null,
    @SerializedName("dob"               ) var dob             : String? = null,
    @SerializedName("address"           ) var address         : String? = null,
    @SerializedName("phone"             ) var phone           : String? = null,
    @SerializedName("email"             ) var email           : String? = null,
    @SerializedName("email_verified_at" ) var emailVerifiedAt : String? = null,
    @SerializedName("created_at"        ) var createdAt       : String? = null,
    @SerializedName("updated_at"        ) var updatedAt       : String? = null
)