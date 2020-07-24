package io.mickeckemi21.section05channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
}

private fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (i in 1..5) {
        send(i * i)
    }
}
