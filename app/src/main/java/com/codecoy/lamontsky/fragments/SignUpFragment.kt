package com.codecoy.lamontsky.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.databinding.DatePickerLayoutBinding
import com.codecoy.lamontsky.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var currentDate: String

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

    }

    private fun datePickerDialog() {

        val dateBinding: DatePickerLayoutBinding =
            DatePickerLayoutBinding.inflate(LayoutInflater.from(requireContext()))

        val dialog = Dialog(requireContext())
        dialog.setContentView(dateBinding.root)
//        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, 600)
        dialog.setCancelable(false)


        currentDate = dateBinding.datePicker.dayOfMonth.toString() + "-" + dateBinding.datePicker.month.toString() +
                "-" + dateBinding.datePicker.year.toString()

        Log.i("TAG", "datePickerDialog: $currentDate" )

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

    }


}


