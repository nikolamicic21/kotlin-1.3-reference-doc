package io.mickeckemi21.part05coroutines.section04asynchronousflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val nums = (1..3).asFlow().onEach { delay(300L) }
    val strs = flowOf("one", "two", "three").onEach { delay(400L) }
    val startTimeZip = System.currentTimeMillis()
    nums.zip(strs) { a, b -> "$a -> $b" }
        .collect { value ->
            println("$value with Zip operator at ${System.currentTimeMillis() - startTimeZip} ms from start")
        }
    val startTimeCombine = System.currentTimeMillis()
    nums.combine(strs) { a, b -> "$a -> $b" }
        .collect { value ->
            println("$value with Combine operator at ${System.currentTimeMillis() - startTimeCombine} ms from start")
        }
}