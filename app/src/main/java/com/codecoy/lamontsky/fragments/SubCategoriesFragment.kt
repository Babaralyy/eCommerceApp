package com.codecoy.lamontsky.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecoy.lamontsky.MainActivity
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.adapter.ProductCatAdapter
import com.codecoy.lamontsky.adapter.SubCategoriesAdapter
import com.codecoy.lamontsky.callback.ProductCatCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.constant.UserIds
import com.codecoy.lamontsky.databinding.FragmentSubcategoriesBinding
import com.codecoy.lamontsky.datamodels.SubCategoriesData
import com.codecoy.lamontsky.datamodels.SubCategoriesResponse
import com.codecoy.lamontsky.network.ProductViewModel


class SubCategoriesFragment : Fragment(), ProductCatCallback {


    private lateinit var productViewModel: ProductViewModel
    private lateinit var activity: MainActivity

    private var subCategoriesList: MutableList<SubCategoriesData> = arrayListOf()
    private lateinit var lManager: LinearLayoutManager
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter

    private lateinit var mBinding: FragmentSubcategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSubcategoriesBinding.inflate(inflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {

        productViewModel = ViewModelProvider(requireActivity())[ProductViewModel::class.java]


        getSubCategories()

    }

    private fun getSubCategories() {

        productViewModel.getSubProductCategories()

        productViewModel.getProductSubCategoriesResponseLiveData()?.observe(requireActivity(),
            Observer<SubCategoriesResponse> {
                if (it.status == true){

                    subCategoriesList = it.data

                    setRecyclerView(subCategoriesList)

                } else {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            })

    }

    private fun setRecyclerView(subCategoriesList: MutableList<SubCategoriesData>) {

        mBinding.rvSubCategories.hasFixedSize()
        lManager = GridLayoutManager(activity, 2)
        mBinding.rvSubCategories.layoutManager = lManager

        subCategoriesAdapter = SubCategoriesAdapter(activity, subCategoriesList, this)

        mBinding.rvSubCategories.adapter = subCategoriesAdapter
        subCategoriesAdapter.notifyDataSetChanged()

    }

    override fun onProductClick(position: Int) {

        val subCategoriesData = subCategoriesList[position]


        UserIds.subCategoriesData = subCategoriesData

        val action = MainFragmentDirections.actionMainFragmentToProductDetailFragment()

        findNavController().navigate(action)


    }

    override fun onAttach(context: Context) {

        super.onAttach(context)

         activity = context as MainActivity

    }

}