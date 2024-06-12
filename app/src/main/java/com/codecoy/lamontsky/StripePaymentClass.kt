package com.codecoy.lamontsky

import android.app.Application
import com.stripe.android.PaymentConfiguration

class StripePaymentClass: Application() {

    override fun onCreate() {
        super.onCreate()
        PaymentConfiguration.init(
            applicationContext,
            "pk_test_qblFNYngBkEdjEZ16jxxoWSM"
        )
    }
}