package com.codecoy.lamontsky.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insertToCart(productCart: ProductCart)

    @Query("DELETE FROM ProductCart WHERE id = :pId")
    fun removeFromCart(pId: Int)

    @Query("SELECT * FROM ProductCart WHERE id = :pId")
    fun getFromCart(pId: Int): ProductCart

    @Query("UPDATE ProductCart SET price = :pPrice, quantity = :pQuantity WHERE id = :pId")
    fun updateCart(pPrice: String, pQuantity: String, pId: Int)

    @Query("SELECT SUM(price) as total FROM ProductCart")
    fun getTotalCartPrice(): LiveData<String>

    @Insert
    fun insertToFav(productFav: ProductFav)

    @Query("DELETE FROM ProductFav WHERE id = :pId")
    fun removeFromFav(pId: Int)

    @Query("SELECT * FROM ProductFav WHERE id = :pId")
    fun getFromFav(pId: Int): ProductFav





    @Query("SELECT * FROM ProductCart")
    fun getAllCartItems(): LiveData<List<ProductCart>>

    @Query("SELECT * FROM ProductFav")
    fun getAllFavItems(): LiveData<List<ProductFav>>

}