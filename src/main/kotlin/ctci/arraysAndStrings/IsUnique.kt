package ctci.arraysAndStrings

private fun main() {
    println(isUnique("abcdea"))
}

//private fun isUnique(string: String): Boolean {
//    val set = mutableSetOf<Char>()
//    string.forEach {
//        if (set.contains(it)) return false
//        set.add(it)
//    }
//    return true
//}

private fun isUnique(string: String): Boolean {
    val bit = Array(128) { false }
    if (string.length > 128) return false
    string.forEach {
        if (bit[it.code]) return false
        bit[it.code] = true
    }
    return true
}
