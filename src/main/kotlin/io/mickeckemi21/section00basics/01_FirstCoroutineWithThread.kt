package io.mickeckemi21.section00basics

import kotlin.concurrent.thread

private fun main() {
    thread {
        Thread.sleep(1000L)
        println("World!")
    }
    println("Hello, ")
    Thread.sleep(2000L)
}