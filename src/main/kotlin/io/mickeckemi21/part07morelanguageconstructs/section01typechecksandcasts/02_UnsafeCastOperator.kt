package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    val x: Any = 1
    val y = x as String
    println(y.length)
}