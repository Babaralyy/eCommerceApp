package com.codecoy.lamontsky.callback

import android.widget.TextView

interface CartCallback {

    fun onDeleteClick(position : Int)

    fun onIncClick(position: Int, tvProductPrice: TextView, tvProductQuantity: TextView)

    fun onDecClick(position: Int, tvProductPrice: TextView, tvProductQuantity: TextView)

}