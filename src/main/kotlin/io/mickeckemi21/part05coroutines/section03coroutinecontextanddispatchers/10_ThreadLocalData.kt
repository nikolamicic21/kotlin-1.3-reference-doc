package io.mickeckemi21.part05coroutines.section03coroutinecontextanddispatchers

import kotlinx.coroutines.*

private fun main() = runBlocking {
    val threadLocal = ThreadLocal<String>()
    threadLocal.set("main")
    println("Pre-main, current thread: ${Thread.currentThread()}, thread local value:" +
            "'${threadLocal.get()}'")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
        println(
            "Launch start, current thread: ${Thread.currentThread()}, thread local value:" +
                    "'${threadLocal.get()}'"
        )
        yield()
        println(
            "After yield, current thread: ${Thread.currentThread()}, thread local value:" +
                    "'${threadLocal.get()}'"
        )
    }
    job.join()
    println("Post-main, current thread: ${Thread.currentThread()}, thread local value:" +
        "'${threadLocal.get()}'")
}