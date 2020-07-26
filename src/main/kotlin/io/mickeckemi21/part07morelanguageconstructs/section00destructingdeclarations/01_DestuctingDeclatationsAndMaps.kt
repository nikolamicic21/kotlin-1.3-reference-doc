package io.mickeckemi21.part07morelanguageconstructs.section00destructingdeclarations

private fun main() {
    val map = mapOf(
        "TEST 0" to 0,
        "TEST 1" to 1
    )
    for ((key, value) in map) {
        println("key: $key, value: $value")
    }
}