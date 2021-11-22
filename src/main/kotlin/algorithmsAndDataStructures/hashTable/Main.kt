package algorithmsAndDataStructures.hashTable

private fun main() {
    println(getPage("www.example.com"))
    println(getPage("www.example1.com"))
    println(getPage("www.example2.com"))
    println(getPage("www.example.com"))
}

private val cache = mutableMapOf<String, String>()

private fun getPage(url: String): String = cache.getOrPut(url) { getDataForPage(url) }

private fun getDataForPage(url: String): String {
    println("getDataForPage called")
    return "Page data for $url"
}
