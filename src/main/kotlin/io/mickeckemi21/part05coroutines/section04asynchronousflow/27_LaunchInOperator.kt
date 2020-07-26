package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    events()
        .onEach { event -> println("Event: $event") }
        .launchIn(this)
    println("Done")
}

private fun events() = flowOf(1, 2, 3).onEach { delay(100L) }