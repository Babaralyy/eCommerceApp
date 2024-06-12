package com.codecoy.lamontsky.fragments

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.FragmentSignInBinding
import com.codecoy.lamontsky.datamodels.SignInResponse
import com.codecoy.lamontsky.datamodels.SignUpResponse
import com.codecoy.lamontsky.network.ApiCall
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInFragment : Fragment() {


    private lateinit var mBinding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSignInBinding.inflate(inflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {


        mBinding.tvSignUp.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            findNavController().navigate(action)
        }

        mBinding.tvCreateAccount.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            findNavController().navigate(action)
        }
        
        
        mBinding.btnSignIn.setOnClickListener { 
            checkCredentials()
        }

    }

    private fun checkCredentials() {
        
        val userEmail: String = mBinding.etEmail.text.toString().trim()
        val userPassword: String = mBinding.etPassword.text.toString().trim()

        if (userEmail.isEmpty()) {
            mBinding.etEmail.error = "Email is required!"
            mBinding.etEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            mBinding.etEmail.error = "Please provide valid email!"
            mBinding.etEmail.requestFocus()
            return
        }

        if (userPassword.isEmpty()) {
            mBinding.etPassword.error = "Password can't be empty!"
            mBinding.etPassword.requestFocus()
            
        } else {
            signIn(userEmail, userPassword)
        }
        
    }

    private fun signIn(userEmail: String, userPassword: String) {

        val dialog = Constant.getDialog(requireContext())
        dialog.show()

        val signInApi = Constant.getRetrofitInstance().create(ApiCall::class.java)

        val signInCall: Call<SignInResponse> = signInApi.signInUser(
            userEmail, userPassword
        )

        signInCall.enqueue(object : Callback<SignInResponse>{
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful){

                    dialog.dismiss()

                    val signInResponse = response.body()

                    if (signInResponse?.status == true){

                        signInResponse.signInData?.let {
                            Constant.saveSignInInfoIntoPref(requireContext(), "userInfo",
                                it
                            )
                        }

                        val action = SignInFragmentDirections.actionSignInFragmentToMainFragment()
                        findNavController().navigate(action)

                    } else {
                        Toast.makeText(requireContext(), signInResponse!!.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {

                dialog.dismiss()
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

}