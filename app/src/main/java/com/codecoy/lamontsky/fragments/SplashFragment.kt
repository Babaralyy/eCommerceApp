package com.codecoy.lamontsky.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.FragmentSplashBinding
import com.codecoy.lamontsky.datamodels.SignInData


class SplashFragment : Fragment() {

    private var signInData: SignInData? = null

    private lateinit var mBinding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSplashBinding.inflate(inflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {

        Handler(Looper.getMainLooper()).postDelayed({

            signInData = Constant.fetchSignInInfoFromPref(requireContext(),"userInfo")
            if (signInData != null){
                val action = SplashFragmentDirections.actionSplashFragmentToMainFragment()
                findNavController().navigate(action)

            } else {
                val action = SplashFragmentDirections.actionSplashFragmentToSignInFragment()
                findNavController().navigate(action)
            }

        }, 1000)

    }

}