package com.example.lottieapp

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application): AndroidViewModel(application) {


    val dataList = ObservableArrayList<String>()





}