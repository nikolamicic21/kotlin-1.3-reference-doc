package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    (1..3).asFlow()
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}

private suspend fun performRequest(request: Int): String {
    delay(1000L)
    return "response $request"
}
