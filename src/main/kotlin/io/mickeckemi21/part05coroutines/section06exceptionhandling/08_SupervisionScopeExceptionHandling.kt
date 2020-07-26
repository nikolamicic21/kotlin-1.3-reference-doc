package io.mickeckemi21.part05coroutines.section06exceptionhandling

import kotlinx.coroutines.*

private fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, e -> println("CoroutineExceptionHandler got $e") }
    supervisorScope {
        val child = launch(handler) {
            println("Child throws the exception")
            throw AssertionError()
        }
        yield()
        println("Scope is completing")
    }
    println("Scope is completed")
}