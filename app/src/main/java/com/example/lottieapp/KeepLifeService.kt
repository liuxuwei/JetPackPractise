package com.example.lottieapp

import android.app.ActivityManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.Exception

class KeepLifeService: Service() {
    private val TAG = "Keeplife"

    private lateinit var mPackageName: String


    private lateinit var mActivityManager: ActivityManager


    private val mBinder = LocalBinder()


    override fun onCreate() {
        super.onCreate()

        mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val process = getProcessName()
        mPackageName = packageName

        var isRunning = isProcessRunning(mActivityManager, mPackageName)


        Log.e(TAG, String.format("onCreate: $mPackageName $process pid=${android.os.Process.myPid()} uid=${android.os.Process.myUid()} isRun=$isRunning"))

        if (!isRunning) {
            Log.e(TAG, "应用被杀死或者异常退出")
        }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }


    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }



    private fun getProcessName(): String? {
        return try {
            val file = File("/proc/" + android.os.Process.myPid() + "/" + "cmdline")
            val bufferReader = BufferedReader(FileReader(file))
            val processName = bufferReader.readLine().trim()
            bufferReader.close()
            processName
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    private fun isProcessRunning(manager: ActivityManager?, name: String): Boolean {

        manager?.runningAppProcesses?.forEach { runningApp ->
            if (runningApp.processName == name) {

                return true
            }
        }

        return false
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopSelf()
        Log.e(TAG, "被移除")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.e(TAG, "service onUnbind")
        return super.onUnbind(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Service onDestroy")
    }


    class LocalBinder : Binder() {

        fun testMethod() {
            Log.e("keep", "keep test")
        }
    }
}