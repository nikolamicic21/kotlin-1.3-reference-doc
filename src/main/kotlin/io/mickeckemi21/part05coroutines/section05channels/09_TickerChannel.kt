package io.mickeckemi21.part05coroutines.section05channels

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

private fun main() = runBlocking {
    val tickerChannel = ticker(delayMillis = 100L, initialDelayMillis = 0L)
    var nextElement = withTimeoutOrNull(1L) { tickerChannel.receive() }
    println("Initial element is available immediately: $nextElement")

    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() }
    println("Next element is not ready in 50ms: $nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100ms: $nextElement")

    println("Consumer pauses for 150ms")
    delay(150L)

    nextElement = withTimeoutOrNull(5) { tickerChannel.receive() }
    println("Next element is available immediately after arge consumer delay: $nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")

    tickerChannel.cancel()
}