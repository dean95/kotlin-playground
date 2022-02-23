package coroutines.examples

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking {
    GlobalScope.launch {
        while (isActive) {
            delay(10)
            println("I'm running!")
        }
    }

    delay(100)

    println("Cancelling GlobalScope!")
    GlobalScope.cancel()

    delay(500)
}

/**
Takeaway:
-   Never use GlobalScope. The GlobalScope doesn't adhere to the structured concurrency principle. It doesn't have any
Job tied to it, and it is running during the whole lifetime of an application. JetBrains are planning to remove this
API altogether in later releases as a part of gradual removal of APIs that allow for unstructured concurrency.
 */
