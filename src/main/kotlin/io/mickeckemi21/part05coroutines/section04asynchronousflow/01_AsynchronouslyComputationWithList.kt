package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100L)
        }
    }
    foo().forEach { value -> println(value) }
}

private suspend fun foo(): List<Int> {
    delay(100L)
    return listOf(1, 2, 3)
}