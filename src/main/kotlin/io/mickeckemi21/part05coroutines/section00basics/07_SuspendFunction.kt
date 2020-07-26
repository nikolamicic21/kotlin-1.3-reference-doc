package io.mickeckemi21.part05coroutines.section00basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    launch {
        doWorld()
    }
    println("Hello, ")
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
