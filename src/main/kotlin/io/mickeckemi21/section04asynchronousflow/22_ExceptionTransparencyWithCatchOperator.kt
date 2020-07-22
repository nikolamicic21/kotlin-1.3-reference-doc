package io.mickeckemi21.section04asynchronousflow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    foo()
        .catch { e -> emit("Caught $e") }
        .collect { value -> println(value) }
}

private fun foo(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i)
        }
    }.map { value ->
        check(value <= 1) { "Crashed on $value" }
        "string $value"
    }