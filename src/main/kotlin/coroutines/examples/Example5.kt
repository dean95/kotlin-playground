package coroutines.examples

import kotlinx.coroutines.*

private val scope = CoroutineScope(Job() + Dispatchers.Default)

private fun main(): Unit = runBlocking {
    // Main Job
    scope.launch {
        // Child 1
        launch {
            while (isActive) {
                // run
            }
        }.invokeOnCompletion {
            println("Child 1 is cancelled!")
        }

        // Child 2
        launch {
            delay(500)
            println("Here goes boom...")
            throw IllegalArgumentException("Boom!")
        }.invokeOnCompletion {
            println("Child 2 is cancelled!")
        }
    }.invokeOnCompletion {
        println("Main Job has completed!")
    }

    // Random coroutine on the same scope
    scope.launch {
        while (isActive) {
            // run
        }
    }.invokeOnCompletion {
        println("Random coroutine is cancelled!")
    }

    delay(1000)
}

/** Output 1
"Here goes boom..."
"Child 1 is cancelled!"
"Child 2 is cancelled!"
"Main Job has completed!"
"Random coroutine is cancelled!"
IllegalArgumentException("Boom!")
 */

/** Output 2
"Here goes boom..."
"Child 2 is cancelled!"
 */