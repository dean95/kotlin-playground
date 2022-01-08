package ctci.arraysAndStrings

private fun main() {
    val input = "Mr John Smith    ".toCharArray()
    println(urlify(input, 13))
}

//private fun urlify(input: CharArray): String {
//    val replaceValue = "%20".toCharArray()
//    val result = mutableListOf<Char>()
//    input.forEach {
//        if (it == ' ') result.addAll(replaceValue.asList())
//        else result.add(it)
//    }
//    return result.joinToString(separator = "")
//}

private fun urlify(input: CharArray, trueLength: Int): CharArray {
    val replaceValue = "%20".toCharArray()
    var firstNonEmptyFound = false
    var spaceCount = 0
    repeat(trueLength) {
        if (input[it].isWhitespace()) spaceCount++
    }
    var currentIndex = (trueLength + spaceCount * 2).dec()
    for (i in input.size.dec() downTo 0) {
        if (input[i].isWhitespace()) {
            if (firstNonEmptyFound.not()) continue
            for (j in replaceValue.size.dec() downTo 0) {
                input[currentIndex] = replaceValue[j]
                currentIndex--
            }
        } else {
            firstNonEmptyFound = true
            input[currentIndex] = input[i]
            currentIndex--
        }
    }
    return input
}
