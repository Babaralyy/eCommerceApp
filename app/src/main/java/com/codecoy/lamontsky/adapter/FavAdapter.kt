package com.codecoy.lamontsky.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecoy.lamontsky.databinding.CartLayBinding
import com.codecoy.lamontsky.databinding.FavLayBinding

import com.codecoy.lamontsky.roomdb.ProductFav

class FavAdapter(private val context: Context,
                 private val productFavList : List<ProductFav>):
    RecyclerView.Adapter<FavAdapter.ViewHolder>()  {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding = FavLayBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productFav = productFavList[position]

    }

    override fun getItemCount(): Int {
        return productFavList.size
    }

    inner class ViewHolder(val mBinding: FavLayBinding): RecyclerView.ViewHolder(mBinding.root)
}