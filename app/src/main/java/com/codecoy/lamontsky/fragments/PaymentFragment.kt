package com.codecoy.lamontsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.databinding.ActivityMainBinding
import com.codecoy.lamontsky.databinding.FragmentPaymentBinding
import com.stripe.android.ApiResultCallback
import com.stripe.android.PaymentConfiguration
import com.stripe.android.Stripe
import com.stripe.android.model.CardParams
import com.stripe.android.model.Source
import com.stripe.android.model.SourceParams
import com.stripe.android.model.Token
import java.lang.ref.WeakReference


class PaymentFragment : Fragment() {



    private lateinit var mainBinding: FragmentPaymentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = FragmentPaymentBinding.inflate(inflater)

        inIt()


        return mainBinding.root
    }

    private fun inIt() {

        mainBinding.payButton.setOnClickListener {
            paymentMethod()
        }

    }


    private fun paymentMethod() {



//
//        mainBinding.cardInputWidget.cardParams?.let { card ->
//            // Create a Stripe token from the card details
//            val stripe = Stripe(requireContext(), PaymentConfiguration.getInstance(requireContext()).publishableKey)
//            stripe.createCardToken(card, object :ApiResultCallback<Token>{
//                override fun onError(e: Exception) {
//
//                }
//
//                override fun onSuccess(result: Token) {
//
//                }
//
//            }
//        }




        val stripe = Stripe(
            requireContext(),
            "pk_test_qblFNYngBkEdjEZ16jxxoWSM"
        )
        val card = mainBinding.cardInputWidget.cardParams
        val cardSourceParams = card?.let { SourceParams.createCardParams(it) }
// The asynchronous way to do it. Call this method on the main thread.
        if (cardSourceParams != null) {
            stripe.createSource(
                cardSourceParams,
                callback = object : ApiResultCallback<Source> {
                    override fun onSuccess(source: Source) {
                        // Store the source somewhere, use it, etc
                    }

                    override fun onError(error: Exception) {
                        // Tell the user that something went wrong
                    }
                }
            )
        }

    }

}