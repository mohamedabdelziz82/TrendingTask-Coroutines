package com.mohamedabdelaziz.trendingtask.core.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohamedabdelaziz.trendingtask.core.utils.internetconnection.InternetConnectionLiveData

abstract class BaseActivity : AppCompatActivity() {
   private var connectionLiveData: InternetConnectionLiveData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = InternetConnectionLiveData(this)
        observeNetworkState()
    }

    private fun observeNetworkState() {
        connectionLiveData!!.observe(this, {
            if (it!!) {
                onConnectionSuccess()
            } else {
                onConnectionFailed()
            }
        })
    }

    protected abstract fun onConnectionSuccess()
    protected abstract fun onConnectionFailed()
}