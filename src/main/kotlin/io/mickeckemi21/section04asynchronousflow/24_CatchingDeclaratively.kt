package io.mickeckemi21.section04asynchronousflow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    foo()
        .onEach { value ->
            check(value <= 1) { "Collected $value" }
            println(value)
        }
        .catch { e -> println("Caught $e") }
        .collect()
}

private fun foo() = flow<Int> {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}