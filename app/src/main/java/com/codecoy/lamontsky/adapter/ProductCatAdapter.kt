package com.codecoy.lamontsky.adapter


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codecoy.lamontsky.callback.ProductCatCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.constant.Constant.TAG
import com.codecoy.lamontsky.databinding.ProductLayBinding
import com.codecoy.lamontsky.datamodels.ProductCatData
import com.codecoy.lamontsky.datamodels.SubCategoriesData


class ProductCatAdapter(
    private val context: Context,
    private val productCatList: MutableList<ProductCatData>,
    private val productCatCallback: ProductCatCallback,

) : RecyclerView.Adapter<ProductCatAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val mBinding = ProductLayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productCatData = productCatList[position]

        Log.i(TAG, "onBindViewHolder: ${productCatList[position]}")

        Glide.with(context).load(Constant.IMG_URL + productCatData.img)
            .into(holder.mBinding.ivProductCat)

        holder.mBinding.tvProductCatTitle.text = productCatData.categoryName

        holder.itemView.setOnClickListener {
            productCatCallback.onProductClick(position)
        }

    }

    override fun getItemCount(): Int {

        Log.i(TAG, "getItemCount: ${productCatList.size}")
        return productCatList.size
    }

    inner class ViewHolder(val mBinding: ProductLayBinding) :
        RecyclerView.ViewHolder(mBinding.root)

    fun updateAdapter(productCatList: List<ProductCatData>) {
        this.productCatList.clear()
        this.productCatList.addAll(productCatList)


        Log.i(TAG, "getItemCount--> OnUpdate: ${this.productCatList.size}")

        notifyDataSetChanged()
    }


}