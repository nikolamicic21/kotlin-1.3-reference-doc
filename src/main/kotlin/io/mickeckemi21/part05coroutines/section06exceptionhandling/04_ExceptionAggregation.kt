package io.mickeckemi21.part05coroutines.section06exceptionhandling

import kotlinx.coroutines.*
import java.io.IOException

private fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception with suppressed ${exception.suppressed.contentToString()}")
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                throw ArithmeticException()
            }
        }
        launch {
            delay(100L)
            throw IOException()
        }
        delay(Long.MAX_VALUE)
    }
    job.join()
}