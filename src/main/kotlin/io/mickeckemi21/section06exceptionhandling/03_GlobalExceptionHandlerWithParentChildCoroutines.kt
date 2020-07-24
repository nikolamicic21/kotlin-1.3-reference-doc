package io.mickeckemi21.section06exceptionhandling

import kotlinx.coroutines.*


private fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }
    val job = GlobalScope.launch(handler) {
        launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                withContext(NonCancellable) {
                    println("Children are cancelled, but exception is not handled until all children terminate")
                    delay(100L)
                    println("The first child finished its non cancellable block")
                }
            }
        }
        launch {
            delay(10L)
            println("Second child throws an exception")
            throw ArithmeticException()
        }
    }
    job.join()
}