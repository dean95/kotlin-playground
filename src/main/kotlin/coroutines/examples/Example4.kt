package coroutines.examples

import kotlinx.coroutines.*

private class MyActivity : AppCompatActivity() {
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect {
                    // Collect ui state
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.someOtherFlow.collect {
                    // Collect some other data
                }
            }
        }
    }
}

// region Helper
public fun LifecycleOwner.addRepeatingJob(
    state: Lifecycle.State,
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
): Job = lifecycleScope.launch(coroutineContext) {
    repeatOnLifecycle(state, block)
}
// endregion

// region Simplified
private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

private fun main() {
    runBlocking {
        val mainJob = scope.launch {
            println("Starting the main job!")
            scope.launch {
                while (isActive) {
                    delay(100)
                    println("I'm alive!!!")
                }
            }
        }
        mainJob.invokeOnCompletion {
            println("The main job is completed/cancelled!")
        }

        delay(100)

        mainJob.cancel()

        delay(500)
        println("Finishing main()...")
    }
}

/**
 Output:
 "Starting the main job!"
 "The main job is completed/cancelled!"
 "I'm alive!!!"
 "I'm alive!!!"
 "I'm alive!!!"
 "I'm alive!!!"
 "Finishing main()..."
 */

// endregion
