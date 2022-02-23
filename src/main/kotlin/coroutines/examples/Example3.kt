package coroutines.examples

import kotlinx.coroutines.*

private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

private fun main() = runBlocking {
    val childJob = Job()

    val mainJob = scope.launch {
        println("Starting the main job!")
        launch(childJob) {
            while (isActive) {
                delay(100)
                println("Scope is active: ${scope.isActive}")
            }
        }
    }
    mainJob.invokeOnCompletion {
        println("The main job is completed/cancelled!")
    }

    scope.cancel()

    delay(500)
    println("Finishing main()...")
}

/**
Output:
"Starting the main job!"
"The main job is completed/cancelled!"
Scope is active: false
Scope is active: false
Scope is active: false
Scope is active: false
Finishing main()...
 */

/**
Takeaways:
- When using a CoroutineContext you should not have a Job there.
- When using a CoroutineScope you should always have a Job there.
 */
