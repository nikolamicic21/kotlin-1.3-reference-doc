package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    try {
        flowOf(1, 2, 3)
            .collectLatest { value -> println(value) }
    } finally {
        println("Done")
    }
}