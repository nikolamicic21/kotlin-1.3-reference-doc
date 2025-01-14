package io.mickeckemi21.part05coroutines.section00basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }
        delay(100L)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over")
}