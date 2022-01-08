package ctci.arraysAndStrings

private fun main() {
    val first = "abcde"
    val second = "edcba"
    println(isPermutation(first, second))
}

//private fun isPermutation(first: String, second: String): Boolean {
//    if (first.length != second.length) return false
//    return first.toCharArray().sorted() == second.toCharArray().sorted()
//}

//private fun isPermutation(first: String, second: String): Boolean {
//    if (first.length != second.length) return false
//    val firstMap = mutableMapOf<Char, Int>()
//    first.forEach {
//        val charCount = firstMap.getOrPut(it) { 0 }
//        firstMap[it] = charCount.inc()
//    }
//    val secondMap = mutableMapOf<Char, Int>()
//    second.forEach {
//        val charCount = secondMap.getOrPut(it) { 0 }
//        secondMap[it] = charCount.inc()
//    }
//    println(firstMap)
//    println(secondMap)
//    return firstMap == secondMap
//}

private fun isPermutation(first: String, second: String): Boolean {
    if (first.length != second.length) return false
    val array = Array(128) { 0 }
    first.forEach { array[it.code]++ }
    second.forEach {
        array[it.code]--
        if (array[it.code] < 0) return false
    }
    return true
}
