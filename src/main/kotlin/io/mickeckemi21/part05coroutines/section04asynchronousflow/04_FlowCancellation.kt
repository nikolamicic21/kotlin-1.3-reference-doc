package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

private fun main() = runBlocking<Unit> {
    withTimeoutOrNull(1300L) {
        foo().collect { value -> println(value) }
    }
    println("Done")
}

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(500L)
        println("Emmiting $i")
        emit(i)
    }
}