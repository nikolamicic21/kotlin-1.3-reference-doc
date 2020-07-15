package io.mickeckemi21.section03coroutinecontextanddispatchers

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

private fun main() = runBlocking {
    logger.info("Started main coroutine")
    val v1 = async(context = CoroutineName("v1coroutine")) {
        delay(500L)
        logger.info("Computing v1")
        252
    }
    val v2 = async(context = CoroutineName("v2coroutine")) {
        delay(500L)
        logger.info("Computing v2")
        6
    }
    logger.info("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}