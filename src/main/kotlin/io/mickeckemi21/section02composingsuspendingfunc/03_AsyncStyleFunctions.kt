package io.mickeckemi21.section02composingsuspendingfunc

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun main() {
    val time = measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()

        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

private fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

private suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

private fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

private suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}