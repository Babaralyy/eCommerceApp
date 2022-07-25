package com.codecoy.lamontsky.constant

import android.app.Dialog
import android.content.Context
import com.codecoy.lamontsky.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {

    private const val BASE_URL = "https://wh717090.ispot.cc/lamont_sky/"
    const val TAG = "TAG"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getDialog (context: Context) : Dialog {
        val dialog  = Dialog(context)
        dialog.setContentView(R.layout.dialog_lay)
        dialog.setCancelable(false)

        return dialog
    }

}


