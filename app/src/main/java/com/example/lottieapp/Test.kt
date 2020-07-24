package com.example.lottieapp

import kotlinx.coroutines.*
import java.util.*

fun main() = runBlocking {
    //    println(intToByteArr(-32).contentToString())
//    println((0xDC shl 8) or (0xFF and 0xFF))
//    println((0xFFDC - 1))

    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)

        }
    }
    delay(1300L)
//    launch {
//        delay(200L)
//        println("Task from runBlocking")
//    }
//
//    coroutineScope {
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope")
//    }
//
//    println("Coroutine scope is over")


}

enum class Apple constructor(private val weight: Int, private val price: Int) {
    FUJI(2, 10),
    RED(3, 11);


    fun weight(): Int {
        return weight
    }

    fun price(): Int {
        return price
    }

}


fun intToByteArr(num: Int): ByteArray {
    val arr = ByteArray(2)
    arr[0] = (num shr 8 and 0xFF).toByte()
    arr[1] = (num and 0xFF).toByte()
    return arr
}