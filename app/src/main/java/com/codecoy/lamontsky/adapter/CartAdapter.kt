package com.codecoy.lamontsky.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codecoy.lamontsky.callback.CartCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.CartLayBinding
import com.codecoy.lamontsky.roomdb.ProductCart

class CartAdapter(private val context: Context,
                  private val productCartList: MutableList<ProductCart>,
                  private val cartCallback: CartCallback
                  ): RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = CartLayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productCart = productCartList[position]

        Glide.with(context).load(Constant.IMG_URL + productCart.productImg)
            .into(holder.mBinding.ivProduct)

        holder.mBinding.tvProductName.text = productCart.productName
        holder.mBinding.tvProductPrice.text = productCart.price
       holder.mBinding.tvProductQuantity.text = productCart.quantity

        holder.mBinding.ivDeleteProduct.setOnClickListener {

            cartCallback.onDeleteClick(position)

        }

        holder.mBinding.tvInc.setOnClickListener {
            cartCallback.onIncClick(position, holder.mBinding.tvProductPrice, holder.mBinding.tvProductQuantity)
        }

        holder.mBinding.tvDec.setOnClickListener {
            cartCallback.onDecClick(position,  holder.mBinding.tvProductPrice, holder.mBinding.tvProductQuantity)
        }
    }

    override fun getItemCount(): Int {
       return productCartList.size
    }

    inner class ViewHolder(val mBinding: CartLayBinding) : RecyclerView.ViewHolder(mBinding.root)
}