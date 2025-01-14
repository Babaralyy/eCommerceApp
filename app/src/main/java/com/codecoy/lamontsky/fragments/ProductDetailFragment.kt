package com.codecoy.lamontsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.databinding.FragmentProductBinding
import com.codecoy.lamontsky.databinding.FragmentProductDetailBinding
import com.codecoy.lamontsky.databinding.FragmentProfileBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class ProductDetailFragment : Fragment() {

    private val imageList = ArrayList<SlideModel>() // Create image list

    private lateinit var mBinding: FragmentProductDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentProductDetailBinding.inflate(inflater)


        imageList.add(SlideModel(R.drawable.helicopter, "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.drone, "Elephants and tigers may become extinct.", ScaleTypes.FIT))


        mBinding.imageSlider.setImageList(imageList)


        return mBinding.root
    }


}