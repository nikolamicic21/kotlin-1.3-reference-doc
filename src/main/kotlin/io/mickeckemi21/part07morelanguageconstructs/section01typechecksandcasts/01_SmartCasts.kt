package io.mickeckemi21.part07morelanguageconstructs.section01typechecksandcasts

private fun main() {
    demo(1)
    demo("")
    demo("Demo")
}

private fun demo(x: Any) {
    if (x !is String || x.length == 0) return

    if (x is String && x.length > 0) {
        println(x.length)
    }
}