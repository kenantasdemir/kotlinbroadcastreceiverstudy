package com.kenant42.kotlinbroadcastreceiverstudy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomChargeLevelReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "LOW BATTERY ", Toast.LENGTH_LONG).show()
    }
}