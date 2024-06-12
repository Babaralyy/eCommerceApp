package com.codecoy.lamontsky.roomdb

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import okhttp3.internal.wait

class RoomProductViewModel(private val roomProductRepo: RoomProductRepo): ViewModel() {


    @OptIn(DelicateCoroutinesApi::class)
    fun insertToCart(productCart: ProductCart) = GlobalScope.launch {
        roomProductRepo.insertToCart(productCart)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertToFav(productFav: ProductFav) = GlobalScope.launch {
        roomProductRepo.insertTopFav(productFav)
    }

     @OptIn(DelicateCoroutinesApi::class)
     fun removeFromFav(id: Int) = GlobalScope.launch {
         roomProductRepo.removeFromFav(id)
     }


     suspend fun getFromFav(id: Int) =
         withContext(Dispatchers.IO) {
             roomProductRepo.getFromFav(id)
         }



   suspend fun removeFromCart(id: Int) =
        withContext(Dispatchers.IO) {
            roomProductRepo.removeFromCart(id)
        }


    suspend fun getFromCart(id: Int) =
        withContext(Dispatchers.IO) {
            roomProductRepo.getFromCart(id)
        }

    suspend fun updateCart(pPrice: String, pQuantity: String, pId: Int) =
        withContext(Dispatchers.IO) {
            roomProductRepo.updateCart(pPrice, pQuantity, pId)
        }

    suspend fun getTotalCartPrice() =
        withContext(Dispatchers.IO) {
            roomProductRepo.getTotalCartPrice()
        }

    fun allCartItems() = roomProductRepo.allCartItems()

    suspend fun allFavItems() =  withContext(Dispatchers.IO) {
        roomProductRepo.allFavItems()
    }

}