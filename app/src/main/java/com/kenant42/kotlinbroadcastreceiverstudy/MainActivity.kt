package com.kenant42.kotlinbroadcastreceiverstudy

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var customChargeLevelReceiver: CustomChargeLevelReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customChargeLevelReceiver = CustomChargeLevelReceiver()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")
        registerReceiver(customChargeLevelReceiver,filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(customChargeLevelReceiver)
    }
}