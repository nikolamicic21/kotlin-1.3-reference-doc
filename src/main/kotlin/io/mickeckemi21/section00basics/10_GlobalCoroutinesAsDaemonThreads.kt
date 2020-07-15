package io.mickeckemi21.section00basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    GlobalScope.launch {
        repeat(1000) {
            println("I'm sleeping $it ...")
            delay(500L)
        }
    }
    delay(1300L)
}