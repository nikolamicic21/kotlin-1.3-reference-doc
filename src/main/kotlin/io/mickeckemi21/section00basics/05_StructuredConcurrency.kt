package io.mickeckemi21.section00basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello, ")
}