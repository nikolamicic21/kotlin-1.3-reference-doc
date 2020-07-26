package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun main() = runBlocking {
    val time = measureTimeMillis {
        foo()
            .collectLatest { value ->
                println("Collecting $value")
                delay(300)
                println("Done $value")
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