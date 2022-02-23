package coroutines.examples

import kotlinx.coroutines.*

// region Problem

private val dataUrls = listOf("url1", "url2", "url3")

private fun main() {
    runBlocking {
        downloadAllData(dataUrls).forEach(::println)
    }
}

suspend fun downloadAllData(urls: List<String>): List<Data> {
    return urls.map { url -> downloadData(url) }
}

suspend fun downloadData(url: String): Data {
    return withContext(Dispatchers.IO) {
        delay(100)
        Data("I am data from: $url")
    }
}

data class Data(val content: String)

//endregion

//region Solution

suspend fun downloadAllDataConcurrently(urls: List<String>): List<Data> = coroutineScope {
    urls.map { url ->
        async {
            downloadData(url)
        }
    }.map { it.await() }
}

//endregion
