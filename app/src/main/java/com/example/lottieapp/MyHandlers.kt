package com.example.lottieapp

import android.util.Log
import android.view.View
import java.lang.Exception
import java.lang.StringBuilder
import java.math.BigDecimal
import java.util.*
import kotlin.collections.HashMap

abstract class MyHandlers {
    private val TAG = "MyHandlers"

    abstract fun onClickFriend(view: View)





}

fun main() {
    print(valueOfStr("ZZZZZZACBD"))
}

fun valueOfStr(str: String): Int {
    val strMap = HashMap<Char, Int>()
    val result = StringBuilder()
    for ((num, charStr) in ('A'..'Z').withIndex()){
        strMap[charStr] = num
    }
    str.forEach {
        if (it !in 'A'..'Z') {
            throw Exception("含非法字符")
        }
        result.append(strMap[it])
    }

    return try {
        Integer.valueOf(result.toString())
    } catch (e: Exception) {
        Int.MAX_VALUE
    }


}