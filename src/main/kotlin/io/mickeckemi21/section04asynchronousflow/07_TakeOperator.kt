package io.mickeckemi21.section04asynchronousflow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    numbers()
        .take(2)
        .collect { value -> println(value) }
}

private suspend fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not be executed")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}