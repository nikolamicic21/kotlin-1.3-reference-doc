package section00basics

import kotlin.concurrent.thread

private fun main() {
    repeat(1_000_000) {
        thread {
            Thread.sleep(1000L)
            print(".")
        }
    }
}