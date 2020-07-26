package io.mickeckemi21.part05coroutines.section03coroutinecontextanddispatchers

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    println("My job is ${coroutineContext[Job]}")
}