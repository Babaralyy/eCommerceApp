package com.codecoy.lamontsky.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var mBinding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(inflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {



        replaceFragment(ProductFragment())

        mBinding.bottomNav.setOnItemReselectedListener {
            when(it.itemId){
                R.id.iHome -> {
                    replaceFragment(ProductFragment())
                }
                R.id.iCart -> {
                    replaceFragment(CartFragment())
                }
                R.id.iOrder -> {
                    replaceFragment(OrderFragment())
                }
                R.id.iProfile -> {
                    replaceFragment(ProfileFragment())
                }
            }
        }

    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLay, fragment).addToBackStack(null)
        fragmentTransaction.commit()
    }



}