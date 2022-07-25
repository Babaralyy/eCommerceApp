package com.codecoy.lamontsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.databinding.FragmentProductBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel


class ProductFragment : Fragment() {

    private val imageList = ArrayList<SlideModel>() // Create image list

    private lateinit var mBinding: FragmentProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentProductBinding.inflate(inflater)

        imageList.add(SlideModel(R.drawable.helicopter, "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.drone, "Elephants and tigers may become extinct.", ScaleTypes.FIT))


        mBinding.imageSlider.setImageList(imageList)

        return mBinding.root
    }

}