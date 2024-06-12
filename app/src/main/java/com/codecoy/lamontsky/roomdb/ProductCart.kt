package com.codecoy.lamontsky.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ProductCart")
class ProductCart(
    @PrimaryKey var id: Int? = null,
    @ColumnInfo(name = "cat_id") var catId: String? = null,
    @ColumnInfo(name = "subCat_id") var subCatId: String? = null,
    @ColumnInfo(name = "product_name") var productName: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "price") var price: String? = null,
    @ColumnInfo(name = "original_price") var original_price: Float? = null,
    @ColumnInfo(name = "quantity") var quantity: String? = null,
    @ColumnInfo(name = "product_img") var productImg: String? = null,
    @ColumnInfo(name = "created_at") var createdAt: String? = null,
    @ColumnInfo(name = "updated_at") var updatedAt: String? = null
)