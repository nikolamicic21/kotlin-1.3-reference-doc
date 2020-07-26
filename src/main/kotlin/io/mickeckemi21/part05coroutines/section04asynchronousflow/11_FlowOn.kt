package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

private fun main() = runBlocking {
    foo().collect { value ->
        log.info("Collected $value")
    }
}

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100L)
        log.info("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)