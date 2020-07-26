package io.mickeckemi21.part07morelanguageconstructs.section00destructingdeclarations

private fun main() {
    val (result, status) = function()
    println("result: $result, status: $status")
}

data class Result(val result: Int, val status: String)

private fun function(): Result = Result(Int.MIN_VALUE, "STATUS")