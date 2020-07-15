package io.mickeckemi21.section03coroutinecontextanddispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val request = launch {
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000L)
            println("job1: I am not affected by cancellation of the request")
        }
        launch {
            delay(100L)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500L)
    request.cancel()
    println("main: Who has survived request cancellation?")
    delay(1100L)
}