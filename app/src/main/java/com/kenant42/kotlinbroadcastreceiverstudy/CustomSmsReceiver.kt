package com.kenant42.kotlinbroadcastreceiverstudy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast

class CustomSmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val b = intent!!.extras
        if (b != null) {
            val pdusObject = b.get("pdus") as Array<Any>
            for (i in pdusObject.indices) {
                val actualMessage: SmsMessage
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val format = b.getString("format")
                    actualMessage = SmsMessage.createFromPdu(pdusObject[i] as ByteArray,format)
                } else {
                    actualMessage = SmsMessage.createFromPdu(pdusObject[i] as ByteArray)
                }

                val no = actualMessage.displayOriginatingAddress
                val message = actualMessage.displayMessageBody

                Toast.makeText(context,"$no - $message ",Toast.LENGTH_LONG).show()
            }
        }
    }
}