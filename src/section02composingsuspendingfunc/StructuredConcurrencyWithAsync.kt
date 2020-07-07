package section02composingsuspendingfunc

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}

private suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}

private suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

private suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}