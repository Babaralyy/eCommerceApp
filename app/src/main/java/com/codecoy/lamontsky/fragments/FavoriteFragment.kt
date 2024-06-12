package com.codecoy.lamontsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.adapter.CartAdapter
import com.codecoy.lamontsky.adapter.FavAdapter
import com.codecoy.lamontsky.databinding.FragmentFavoriteBinding
import com.codecoy.lamontsky.roomdb.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment() {


    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var favAdapter: FavAdapter

    private lateinit var roomProductViewModel: RoomProductViewModel
    private lateinit var productFavList: List<ProductFav>

    private lateinit var mBinding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentFavoriteBinding.inflate(inflater)


        inIt()

        return mBinding.root
    }

    private fun inIt() {


        mBinding.rvFavorite.hasFixedSize()
        layoutManager = LinearLayoutManager(activity)
        mBinding.rvFavorite.layoutManager = layoutManager


        val roomProductRepo = RoomProductRepo(AppDatabase(requireContext()))

        val roomProductViewModelFactory = RoomProductViewModelFactory(roomProductRepo)

        roomProductViewModel =
            ViewModelProvider(this, roomProductViewModelFactory)[RoomProductViewModel::class.java]

        getAllItemsFromFav()

    }

    private fun getAllItemsFromFav() {

        CoroutineScope(Dispatchers.Main).launch {

            roomProductViewModel.allFavItems().observe(requireActivity()
            ) {

                productFavList = it

                setRecyclerView()

            }

        }

    }

    private fun setRecyclerView() {

        favAdapter = FavAdapter(requireContext(), productFavList)

        mBinding.rvFavorite.adapter = favAdapter
        favAdapter.notifyDataSetChanged()

    }

}