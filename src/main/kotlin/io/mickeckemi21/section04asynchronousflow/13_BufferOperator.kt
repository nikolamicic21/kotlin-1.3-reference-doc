package io.mickeckemi21.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun main() = runBlocking {
    val time = measureTimeMillis {
        foo().buffer()
            .collect { value ->
            delay(300L)
            println(value)
        }
    }
    println("Collected in $time ms")
}

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100L)
        emit(i)
    }
}