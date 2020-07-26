package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow().onEach { delay(100L) }
        .flatMapConcat { requestFlow(it) }
        .collect { value ->
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}

private fun requestFlow(request: Int): Flow<String> = flow {
    emit("$request: First")
    delay(500L)
    emit("$request: Second")
}
