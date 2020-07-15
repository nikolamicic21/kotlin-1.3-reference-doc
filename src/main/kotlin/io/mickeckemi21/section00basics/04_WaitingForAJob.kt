package io.mickeckemi21.section00basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello, ")
    job.join()
}