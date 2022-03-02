package coroutines.examples

import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

private fun main(): Unit = runBlocking {
    scope.launch {
        supervisorScope {
            println("I am the supervisor scope!")

            val deferred = async {
                delay(50)
                throw IllegalArgumentException("Async Boom!")
            }

            println("Supervisor scope done!")
        }
    }

    delay(200)
    println("Main is done!")
}

/** Output 1:
"I am the supervisor scope!"
"Supervisor scope done!"
"Main is done!"
 */

/** Output 2:
"I am the supervisor scope!"
"Supervisor scope done!"
IllegalArgumentException("Async Boom!")
"Main is done!"
 */
