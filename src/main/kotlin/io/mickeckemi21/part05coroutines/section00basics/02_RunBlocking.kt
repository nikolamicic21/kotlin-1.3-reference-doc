package io.mickeckemi21.part05coroutines.section00basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello, ")
    runBlocking {
        delay(2000L)
    }
}