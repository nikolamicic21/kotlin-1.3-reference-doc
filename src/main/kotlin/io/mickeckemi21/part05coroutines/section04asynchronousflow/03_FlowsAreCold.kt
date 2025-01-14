package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    println("Calling foo...")
    val flow = foo()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}

private fun foo(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100L)
        emit(i)
    }
}