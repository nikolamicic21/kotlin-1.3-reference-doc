package section02composingsuspendingfunc

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        one.start()
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

private suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

private suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}