package com.codecoy.lamontsky.fragments

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toFile
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.codecoy.lamontsky.constant.Constant
import com.codecoy.lamontsky.databinding.DatePickerLayoutBinding
import com.codecoy.lamontsky.databinding.FragmentSignUpBinding
import com.codecoy.lamontsky.datamodels.SignUpResponse
import com.codecoy.lamontsky.network.ApiCall
import gun0912.tedimagepicker.builder.TedImagePicker
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException


class SignUpFragment : Fragment() {

    private lateinit var currentDate: String
    private lateinit var uri: Uri

    private lateinit var mBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentSignUpBinding.inflate(inflater)

        inIt()

        return mBinding.root
    }

    private fun inIt() {

        mBinding.btnSignInBack.setOnClickListener {

            val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
            findNavController().navigate(action)

        }

        mBinding.tvSignIn.setOnClickListener {

            val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
            findNavController().navigate(action)

        }

        mBinding.btnSigUp.setOnClickListener {

            checkCredentials()

        }


        mBinding.etDob.setOnClickListener {
            datePickerDialog()
        }


        mBinding.ivCamera.setOnClickListener {
            chooseImage()
        }

    }

    private fun chooseImage() {

        TedImagePicker.with(requireContext())
            .start { uri -> showSingleImage(uri) }
    }

    private fun showSingleImage(uri: Uri) {

        this.uri = uri
        Glide.with(requireContext()).load(uri).into(mBinding.ivProfile)

    }

    private fun datePickerDialog() {

        val dateBinding: DatePickerLayoutBinding =
            DatePickerLayoutBinding.inflate(LayoutInflater.from(requireContext()))

        val dialog = Dialog(requireContext())
        dialog.setContentView(dateBinding.root)
//        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, 600)
        dialog.setCancelable(false)


        currentDate =
            dateBinding.datePicker.dayOfMonth.toString() + "-" + dateBinding.datePicker.month.toString() +
                    "-" + dateBinding.datePicker.year.toString()

        Log.i("TAG", "datePickerDialog: $currentDate")

        dateBinding.datePicker.setOnDateChangedListener { _, i, i2, i3 ->
            Log.i("TAG", "datePickerDialog--onDateChange: $i$i2$i3")
        }

        dateBinding.btnDone.setOnClickListener {

        }

        dateBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()


    }

    private fun checkCredentials() {

        val firstName: String = mBinding.etName.text.toString().trim()
        val userName: String = mBinding.etUserName.text.toString().trim()
        val userDob: String = mBinding.etDob.text.toString().trim()
        val userAddress: String = mBinding.etAddress.text.toString().trim()
        val userNumber: String = mBinding.etNumber.text.toString().trim()
        val userEmail: String = mBinding.etEmail.text.toString().trim()
        val userPassword: String = mBinding.etPassword.text.toString().trim()


        if (firstName.isEmpty()) {
            mBinding.etName.error = "Name is required!"
            mBinding.etName.requestFocus()
            return
        }

        if (userName.isEmpty()) {
            mBinding.etUserName.error = "Username is required!"
            mBinding.etUserName.requestFocus()
            return
        }

        if (userDob.isEmpty()) {
            mBinding.etDob.error = "DOB is required!"
            mBinding.etDob.requestFocus()
            return
        }

        if (userAddress.isEmpty()) {
            mBinding.etAddress.error = "Address is required!"
            mBinding.etAddress.requestFocus()
            return
        }

        if (userNumber.isEmpty()) {
            mBinding.etNumber.error = "Phone Number is required!"
            mBinding.etNumber.requestFocus()
            return
        }

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
            return
        }
        if (userPassword.length < 8) {
            mBinding.etPassword.error = "Password should be greater than 8 characters!"
            mBinding.etPassword.requestFocus()
        } else {
            signUp(firstName, userName, userDob, userAddress, userNumber, userEmail, userPassword)
        }

    }

    private fun signUp(
        firstName: String, userName: String, userDob: String, userAddress: String,
        userNumber: String, userEmail: String, userPassword: String
    ) {

        val dialog = Constant.getDialog(requireContext())
        dialog.show()

        val file: File = this.uri.toFile()

        val filePart: MultipartBody.Part = MultipartBody.Part.createFormData(
            "file", file.name, file
                .asRequestBody("image/*".toMediaTypeOrNull())
        )

        val signUpApi = Constant.getRetrofitInstance().create(ApiCall::class.java)

        val signUpCall:Call<SignUpResponse> = signUpApi.createUser(filePart,
            firstName,
            userName,
            userDob,
            userAddress,
            userNumber,
            userEmail,
            userPassword)


        signUpCall.enqueue(object :Callback<SignUpResponse> {

            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                if (response.isSuccessful) {

                    dialog.dismiss()

                    Log.i(Constant.TAG, "signUp: ${response.body()}")
                }
            }
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                dialog.dismiss()
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()

            }
        })


    }


}



