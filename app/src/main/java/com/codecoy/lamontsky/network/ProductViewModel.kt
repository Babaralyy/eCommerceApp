package com.codecoy.lamontsky.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codecoy.lamontsky.datamodels.ProductCatResponse

class ProductViewModel: ViewModel() {

    private val productRepo = ProductRepo()
    private var productCatResponseLiveData: LiveData<ProductCatResponse>? = null

    fun getAllProductsCat(){
        productRepo.getAllProductsCat()
        productCatResponseLiveData = productRepo.getProductCatResponseLiveData()
    }

    fun getProductCatResponseLiveData() : LiveData<ProductCatResponse>? {
        return productCatResponseLiveData
    }

}