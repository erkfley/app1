package com.volumebooster.pro.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class HeadsetPlugReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_HEADSET_PLUG) {
            val state = intent.getIntExtra("state", -1)
            val isConnected = state == 1
            // Handle headset connection change
        }
    }
}
