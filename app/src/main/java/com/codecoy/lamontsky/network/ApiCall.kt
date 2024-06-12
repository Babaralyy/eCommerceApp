package com.codecoy.lamontsky.network

import com.codecoy.lamontsky.datamodels.ProductCatResponse
import com.codecoy.lamontsky.datamodels.SignInResponse
import com.codecoy.lamontsky.datamodels.SignUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiCall {

    @Multipart
    @POST("api/add_users")
    fun createUser(
        @Part profile_img: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("username")username: RequestBody,
        @Part("dob") dob: RequestBody,
        @Part("address") address: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("email") email: RequestBody,
        @Part("password") password: RequestBody
    ): Call<SignUpResponse>


    @FormUrlEncoded
    @POST("api/login")
    fun signInUser(
        @Field("email") userEmail: String,
        @Field("password") userPassword: String
    ): Call<SignInResponse>


    @GET("api/category")
    fun getProductCats() : Call<ProductCatResponse>


//    @Body signUpBodyData: SignUpBodyData

    /*   @Field("name") firstName: String,
       @Field("username") userName: String,
       @Field("dob") userDob: String,
       @Field("address") userAddress: String,
       @Field("phone") userNumber: String,
       @Field("email") userEmail: String,
       @Field("password") userPassword: String*/

/*      firstName,
        userName,
        userDob,
        userAddress,
        userNumber,
        userEmail,
        userPassword*/

//   val filePart: MultipartBody.Part = MultipartBody.Part.createFormData(
//        "file", file.name, file
//            .asRequestBody("image/*".toMediaTypeOrNull())
//    )

//    @Part firstName: MultipartBody.Part,
//    @Part userName: MultipartBody.Part,
//    @Part userDob: MultipartBody.Part,
//    @Part userAddress: MultipartBody.Part,
//    @Part userNumber: MultipartBody.Part,
//    @Part userEmail: MultipartBody.Part,
//    @Part userPassword: MultipartBody.Part

//    MultipartBody.Part.createFormData("profile_img", file.name, requestBody),
//    MultipartBody.Part.createFormData("name", firstName),
//    MultipartBody.Part.createFormData("username", userName),
//    MultipartBody.Part.createFormData("dob", userDob),
//    MultipartBody.Part.createFormData("address", userAddress),
//    MultipartBody.Part.createFormData("phone", userNumber),
//    MultipartBody.Part.createFormData("email", userEmail),
//    MultipartBody.Part.createFormData("password", userPassword)

}