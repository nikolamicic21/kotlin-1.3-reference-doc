package io.mickeckemi21.section06exceptionhandling

import kotlinx.coroutines.*
import java.io.IOException

private fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }
    val job = GlobalScope.launch(handler) {
        val child = launch {
            launch {
                launch {
                    throw IOException()
                }
            }
        }
        try {
            child.join()
        } catch (e: CancellationException) {
            println("Rethrowing CancellationException with original cause")
            throw e
        }
    }
    job.join()
}