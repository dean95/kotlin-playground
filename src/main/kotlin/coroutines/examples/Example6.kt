package coroutines.examples

import kotlinx.coroutines.*

private fun main() = runBlocking {
    val result = supervisorScope {
        launch {
            delay(100)
            throw IllegalArgumentException("A total fiasco!")
        }

        launch {
            delay(200)
            println("Hi there!")
        }

        "Result!"
    }

    println("Got result: $result")
}

/** Output 1:
IllegalArgumentException("A total fiasco!")
 */

/** Output 2:
IllegalArgumentException("A total fiasco!")
"Hi there!"
"Got result: Result!"
 */
