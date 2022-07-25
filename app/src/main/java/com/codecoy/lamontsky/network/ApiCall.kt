package com.codecoy.lamontsky.network

import com.codecoy.lamontsky.datamodels.SignUpResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiCall {

    @POST("api/add_users")
    fun createUser(
        @Part("profile_img") profile_img: MultipartBody.Part,
        @Field("name") firstName: String,
        @Field("username") userName: String,
        @Field("dob") userDob: String,
        @Field("address") userAddress: String,
        @Field("phone") userNumber: String,
        @Field("email") userEmail: String,
        @Field("password") userPassword: String
    ): Call<SignUpResponse>

}