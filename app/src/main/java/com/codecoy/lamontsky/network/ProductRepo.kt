package com.codecoy.lamontsky.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.datamodels.ProductCatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepo {

    private val retrofit = Constant.getRetrofitInstance()
    private val productApi = retrofit.create(ApiCall::class.java)

    private var productCatResponse: ProductCatResponse = ProductCatResponse()
    private val productCatResponseLiveData: MutableLiveData<ProductCatResponse> = MutableLiveData()


    fun getAllProductsCat() {

        val productApiCall = productApi.getProductCats()

        productApiCall.enqueue(object : Callback<ProductCatResponse> {
            override fun onResponse(
                call: Call<ProductCatResponse>,
                response: Response<ProductCatResponse>
            ) {
                if (response.isSuccessful) {
                    productCatResponse = response.body()!!

                    productCatResponseLiveData.postValue(productCatResponse)
                }
            }

            override fun onFailure(call: Call<ProductCatResponse>, t: Throwable) {
                productCatResponse.status = false
                productCatResponse.message = t.message
            }

        })

    }

    fun getProductCatResponseLiveData() : LiveData<ProductCatResponse> {
        return productCatResponseLiveData
    }
}