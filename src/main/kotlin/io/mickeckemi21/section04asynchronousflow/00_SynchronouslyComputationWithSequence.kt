package io.mickeckemi21.section04asynchronousflow

private fun main() {
    foo().forEach { value -> println(value) }
}

private fun foo(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100L)
        yield(i)
    }
}
