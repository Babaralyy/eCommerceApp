package com.codecoy.lamontsky.constant

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.codecoy.lamontsky.R
import com.codecoy.lamontsky.datamodels.SignInData
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {

    private const val BASE_URL = "https://wh717090.ispot.cc/lamont_sky/"
    const val TAG = "TAG"

     private var signInData: SignInData? = null
    var userId : Int? = null

    private lateinit var sharedPreferences: SharedPreferences

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

    fun saveSignInInfoIntoPref(context: Context, userInfo: String, signInData: SignInData ){

        sharedPreferences = context.getSharedPreferences(userInfo, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        val gson = Gson()
        val json = gson.toJson(signInData)

        editor.putString("userData", json)

        Log.i("TAG", "saveInfoIntoPref: $json")

        editor.apply()
    }

    fun fetchSignInInfoFromPref(context: Context, userInfo: String) : SignInData? {

        sharedPreferences = context.getSharedPreferences(userInfo, Context.MODE_PRIVATE)

        val gson = Gson()
        val json = sharedPreferences.getString("userData", "")

        signInData =
            gson.fromJson(json, SignInData::class.java)
        return if (signInData != null){
            userId = (signInData!!.id)
            Log.i(
                "TAG",
                "saveInfoIntoPref: login_id" + signInData!!.id)
            signInData
        } else{
            null
        }

    }

}


