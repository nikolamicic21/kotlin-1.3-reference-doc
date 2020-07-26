package io.mickeckemi21.part07morelanguageconstructs.section02thisexpression

class A {
    inner class B {
        fun Int.foo() {
            val a = this@A
            val b = this@B

            val c = this // foo()'s receiver
            val c1 = this@foo // foo()'s receiver

            val funLit = lambda@fun String.() {
                val d = this // fulLit's receiver
            }

            val funLit2 = { s: String ->
                val d1 = this // foo()'s receiver
            }
        }
    }
}