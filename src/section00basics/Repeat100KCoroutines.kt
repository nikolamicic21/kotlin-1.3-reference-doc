package section00basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    repeat(1_000_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}