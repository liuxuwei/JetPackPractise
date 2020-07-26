package com.example.lottieapp

import android.app.Application
import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.lottieapp.db.ItemBean
import com.example.lottieapp.db.UserDatabase
import kotlin.concurrent.thread

class MyApp : Application() {

    private val worker = OneTimeWorkRequest.Builder(ListWorker::class.java).build()

    override fun onCreate() {
        super.onCreate()
        WorkManager.getInstance(this).enqueue(worker)
    }

    class ListWorker(val context: Context, params: WorkerParameters) : Worker(context, params) {
        override fun doWork(): Result {
            val itemDao = UserDatabase.getInstance(context)
                .getItemDao()
            val list = mutableListOf<ItemBean>()
            for (i in 1..300) {
                list.add(ItemBean(i, "item $i", i % 9))
            }


            itemDao.insert(list)


            return Result.success()
        }

    }
}