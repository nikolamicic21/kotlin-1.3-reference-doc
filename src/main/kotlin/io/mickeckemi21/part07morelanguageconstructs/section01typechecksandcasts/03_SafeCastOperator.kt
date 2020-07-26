package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    val x: Any = 1
    val y: String? = x as? String
    println(y)
}