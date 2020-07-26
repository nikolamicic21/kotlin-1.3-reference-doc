package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)

    println(somePair.asPairOf<String, Any>())
    println(somePair.asPairOf<String, Int>())
    println(somePair.asPairOf<String, List<*>>())
    println(somePair.asPairOf<String, List<String>>())
}

private inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}