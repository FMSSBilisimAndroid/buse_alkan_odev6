package com.busealkan.coroutinescounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.busealkan.coroutinescounter.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        infiniteLoop()

        CoroutineScope(Dispatchers.IO).launch {
            val answer = doNetworkCall()

            withContext(Dispatchers.Main) {
                Log.v("PATIKA", answer)
            }
        }
    }

    private fun infiniteLoop() {
        var counter = 1
        while(true){
            while (counter <= 10) {
                Log.v("PATIKA", counter.toString())
                counter++
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(2000L)
        return "Network Answer Called"
    }
}