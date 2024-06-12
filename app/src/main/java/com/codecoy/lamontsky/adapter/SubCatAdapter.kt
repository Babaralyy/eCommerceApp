package com.codecoy.lamontsky.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codecoy.lamontsky.callback.ProductCatCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.ProductLayBinding
import com.codecoy.lamontsky.datamodels.ProductCatData
import com.codecoy.lamontsky.datamodels.SubCatData

class SubCatAdapter(
    private val context: Context,
    private val subCatList: MutableList<SubCatData>,
    private val productCatCallback: ProductCatCallback,
) : RecyclerView.Adapter<SubCatAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = ProductLayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val subCatData = subCatList[position]

        Glide.with(context).load(Constant.IMG_URL + subCatData.img)
            .into(holder.mBinding.ivProductCat)


        holder.mBinding.tvProductCatTitle.text = subCatData.subcategoryName

        holder.itemView.setOnClickListener {
            productCatCallback.onProductClick(position)
        }

    }

    override fun getItemCount(): Int {
        return subCatList.size
    }

    inner class ViewHolder(val mBinding: ProductLayBinding) : RecyclerView.ViewHolder(mBinding.root)


    fun updateSubCatList(subCatLis: List<SubCatData>) {
        this.subCatList.clear()
        this.subCatList.addAll(subCatLis)


        Log.i(Constant.TAG, "getItemCount--> OnUpdate: ${this.subCatList.size}")

        notifyDataSetChanged()
    }
}