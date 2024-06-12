package com.codecoy.lamontsky.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codecoy.lamontsky.callback.ProductCatCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.ProductLayBinding
import com.codecoy.lamontsky.datamodels.SubCatData
import com.codecoy.lamontsky.datamodels.SubCategoriesData

class SubCategoriesAdapter(

    private val context: Context,
    private val subCategoriesList: MutableList<SubCategoriesData>,
    private val productCatCallback: ProductCatCallback,

): RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = ProductLayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val subCategoriesData = subCategoriesList[position]

        Glide.with(context).load(Constant.IMG_URL + subCategoriesData.ProductImages[0].productImg)
            .into(holder.mBinding.ivProductCat)


        holder.mBinding.tvProductCatTitle.text = subCategoriesData.productName

        holder.itemView.setOnClickListener {
            productCatCallback.onProductClick(position)
        }

    }

    override fun getItemCount(): Int {
        return subCategoriesList.size
    }

    inner class ViewHolder(val mBinding: ProductLayBinding) : RecyclerView.ViewHolder(mBinding.root)

}