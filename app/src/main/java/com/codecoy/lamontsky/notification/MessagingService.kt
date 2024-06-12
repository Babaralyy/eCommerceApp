package com.codecoy.lamontsky.notification

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.codecoy.lamontsky.constant.Constant.TAG
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MessagingService: FirebaseMessagingService() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onNewToken(deviceToken: String) {
        super.onNewToken(deviceToken)

        Log.i(TAG, "onNewToken: $deviceToken")

        saveTokenIntoPref(deviceToken)
    }


    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
    }

    private fun saveTokenIntoPref(deviceToken: String) {

       sharedPreferences = getSharedPreferences("DeviceToken", Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("deviceToken", deviceToken)

        Log.i(TAG, "deviceToken: $deviceToken")

        editor.apply()

    }

}