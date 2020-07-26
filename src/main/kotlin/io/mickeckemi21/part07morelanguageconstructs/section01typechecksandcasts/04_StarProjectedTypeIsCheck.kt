package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    val list: List<Any> = arrayListOf(1, 2, 3)
    if (list is List<*>) {
        println(list)
    }
    if (list is ArrayList) {
        println("list is smart casted to ArrayList")
    }
}