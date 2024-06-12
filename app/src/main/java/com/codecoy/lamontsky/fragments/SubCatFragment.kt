package com.codecoy.lamontsky.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.adapter.SubCatAdapter
import com.codecoy.lamontsky.callback.ProductCatCallback
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.constant.UserIds
import com.codecoy.lamontsky.databinding.FragmentSubcatBinding
import com.codecoy.lamontsky.datamodels.SubCatData
import com.codecoy.lamontsky.network.ProductViewModel


class SubCatFragment : Fragment() , ProductCatCallback{

    private lateinit var productViewModel: ProductViewModel

    private var subCatList: MutableList<SubCatData> = arrayListOf()
    private lateinit var lManager: LinearLayoutManager
    private lateinit var productCatAdapter: SubCatAdapter


    private lateinit var mBinding: FragmentSubcatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSubcatBinding.inflate(layoutInflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {

        productViewModel = ViewModelProvider(requireActivity())[ProductViewModel::class.java]

        setRecyclerView()

        getProductSubCat()

    }

    private fun getProductSubCat() {

        productViewModel.getSubCat()

        productViewModel.getSubCatResponseLiveData()?.observe(requireActivity()
        ) {
            if (it.status == true){

                subCatList = it.data as MutableList<SubCatData>


                productCatAdapter.updateSubCatList(subCatList)

                Log.i(Constant.TAG, "getProductList: ${it.message}")

            } else {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setRecyclerView() {

        mBinding.rvSubCat.hasFixedSize()
        lManager = GridLayoutManager(requireContext(), 2)


        mBinding.rvSubCat.layoutManager = lManager
        productCatAdapter = SubCatAdapter(requireContext(), subCatList, this)

        mBinding.rvSubCat.adapter = productCatAdapter
        productCatAdapter.notifyDataSetChanged()

    }

    override fun onProductClick(position: Int) {


        val subCatData = subCatList[position]

        UserIds.subCatId = subCatData.id!!

        replaceFragment(SubCategoriesFragment())

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLay, fragment)
        fragmentTransaction.commit()

    }

}