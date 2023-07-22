package com.example.lesson2ultrapro_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.example.lesson2ultrapro_2.R.id.batteryLevelText

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            applicationContext.registerReceiver(null, ifilter)
        }

        val level: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1

        val batteryPct: Float = level.toFloat() / scale.toFloat()
        val batteryPercentage: Int = (batteryPct * 100).toInt()

        var batteryLevelTextView = findViewById<TextView>(batteryLevelText)
        batteryLevelTextView.text = "Battery Level: $batteryPercentage%"
    }

    override fun onResume() {
        super.onResume()
        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            applicationContext.registerReceiver(null, ifilter)
        }

        val level: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
        val scale: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1

        val batteryPct: Float = level.toFloat() / scale.toFloat()
        val batteryPercentage: Int = (batteryPct * 100).toInt()

        var batteryLevelTextView = findViewById<TextView>(batteryLevelText)
        batteryLevelTextView.text = "Battery Level: $batteryPercentage%"
    }






}