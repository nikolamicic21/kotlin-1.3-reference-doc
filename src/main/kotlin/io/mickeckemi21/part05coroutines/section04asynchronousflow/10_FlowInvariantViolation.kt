package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun main() = runBlocking<Unit> {
    flow {
        withContext(Dispatchers.Default) {
            for (i in 1..3) {
                Thread.sleep(100L)
                emit(i)
            }
        }
    }.collect {
        value -> println(value)
    }
}