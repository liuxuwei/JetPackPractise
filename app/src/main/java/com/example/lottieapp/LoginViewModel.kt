package com.example.lottieapp

import android.app.Application
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lottieapp.db.UserBean
import com.example.lottieapp.db.UserDatabase
import kotlin.concurrent.thread

class LoginViewModel(application: Application): AndroidViewModel(application) {


    val uname = ObservableField<String>()
    val upwd = ObservableField<String>()
    private val context = application.applicationContext

    val loginOk = MutableLiveData<Boolean>()


    fun login() {
        Log.e("TAG", "login")
        val user = UserBean(0, "张三", 1, 20, "重庆")


        thread {
            UserDatabase.getInstance(context)
                .getUserDao()
                .insert(user)
        }
        SystemClock.sleep(2000)
        loginOk.value = true
    }
}