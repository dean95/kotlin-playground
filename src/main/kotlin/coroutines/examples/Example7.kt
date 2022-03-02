package coroutines.examples

import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

private fun main(): Unit = runBlocking {
    val deferred = scope.async {
        delay(50)
        throw IllegalStateException("Async Boom!")
    }

    delay(100)

    println("I'm done")
}

/** Output 1:
"I'm done"
 */

/** Output 2:
IllegalStateException("Async Boom!")
 */

/** Output 3:
IllegalStateException("Async Boom!")
"I'm done"
 */
