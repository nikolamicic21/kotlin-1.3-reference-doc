package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
private fun main() = runBlocking {
    flowOf(1, 2, 3)
        .onCompletion { println("Done") }
        .collect { value -> println(value) }
}