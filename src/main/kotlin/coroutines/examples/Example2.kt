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
