package io.mickeckemi21.part05coroutines.section03coroutinecontextanddispatchers

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val request = launch {
        repeat(3) {
            launch {
                delay((it + 1) * 2000L)
                println("Coroutine $it is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join()
    println("Now processing of the request is complete")
}