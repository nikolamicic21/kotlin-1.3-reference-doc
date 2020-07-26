package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    val obj: Any = "TEST"
    val obj1: Any = 1

    if (obj is String) {
        println(obj.length)
    }

    if (obj1 !is String) {
        println("Not a String")
    }

}