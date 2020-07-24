package com.example.lottieapp

import android.animation.Animator
import android.content.*
import android.content.pm.ServiceInfo.FLAG_USE_APP_ZYGOTE
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.webkit.WebView
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.lottieapp.KeepLifeService.LocalBinder
import com.example.lottieapp.databinding.ActivityMainBinding
import com.example.lottieapp.db.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mIntent: Intent
    val TAG = "MainActivity===="
    private lateinit var mBinder: LocalBinder

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val webView: WebView = WebView(this)
        webView.isEnabled = false
        webView.loadUrl("http://www.baidu.com")



        UserDatabase
            .getInstance(this)
            .getLoginStatusDao()
            .queryStatus()
            .observe(this, Observer { logged ->

                if (logged != true) {
                    Navigation.findNavController(this, R.id.nav_host_main).navigate(R.id.nav_to_login)
                }

            })


    }




    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }


//    class TestHandler {
//
//        fun testClick(view: View) {
//            when (view.id) {
//                R.id.btn1 -> {
//                    Log.e("TAG", "btn1.... clicked")
//
//
//                }
//                R.id.btn2 -> {
//                    Log.e("TAG", "btn2222 ... clicked")
//                }
//            }
//        }
//    }

    private fun requestIgnoreBatteryOptimizations() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            try {
                val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)
                intent.data = Uri.parse("package:$packageName")
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {

        }
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }


    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        super.onDestroy()
        stopService(mIntent)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun finish() {
        Log.e(TAG, "finish")
        super.finishAndRemoveTask()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstance")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState")
    }


}
