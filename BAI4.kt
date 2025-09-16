package com.example.myapplication

import kotlinx.coroutines.*

// Khai báo hàm tạm ngưng
suspend fun getValue(): Double {
    delay(500)
    return Math.random() * 100
}

// Gọi hàm tạm ngưng từ một hàm tạm ngưng khác
suspend fun processValue() {
    val value = getValue()
    println("Processed value: ${value * 2}")
}


object DataProviderManager {
    fun provideData(): String = "Data from provider"
}

// Tạo một lớp enum
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

// MAIN
fun main() = runBlocking {
    println("=== Coroutine Demo ===")


    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("Value from GlobalScope.launch: $output")
    }

    val output = getValue()
    println("Value from runBlocking: $output")

    processValue()

    job.cancel()

    val deferred: Deferred<Double> = async {
        getValue()
    }
    println("Output is ${deferred.await()}")

    println(DataProviderManager.provideData())

    try {
        val risky = 10 / 0
        println(risky)
    } catch (exception: Exception) {
        println("Caught exception: ${exception.message}")
    }

    val direction = Direction.NORTH
    when (direction) {
        Direction.NORTH -> println("Going north")
        Direction.SOUTH -> println("Going south")
        Direction.WEST -> println("Going west")
        Direction.EAST -> println("Going east")
    }
}
