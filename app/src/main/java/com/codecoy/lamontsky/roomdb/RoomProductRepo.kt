package com.codecoy.lamontsky.roomdb

class RoomProductRepo(private val appDatabase: AppDatabase) {

     fun insertToCart(productCart: ProductCart) = appDatabase.productDao().insertToCart(productCart)

     fun insertTopFav(productFav: ProductFav) = appDatabase.productDao().insertToFav(productFav)

     fun removeFromFav(id: Int) = appDatabase.productDao().removeFromFav(id)

     fun removeFromCart(id: Int) = appDatabase.productDao().removeFromCart(id)

     fun getFromFav(id: Int): ProductFav = appDatabase.productDao().getFromFav(id)

    fun getFromCart(id: Int): ProductCart = appDatabase.productDao().getFromCart(id)

    fun updateCart(pPrice: String, pQuantity: String, pId: Int) = appDatabase.productDao().updateCart(pPrice, pQuantity, pId)

    fun getTotalCartPrice() = appDatabase.productDao().getTotalCartPrice()

    fun allCartItems() = appDatabase.productDao().getAllCartItems()

    fun allFavItems() = appDatabase.productDao().getAllFavItems()

}