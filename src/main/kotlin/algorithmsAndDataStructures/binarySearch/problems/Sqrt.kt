package algorithmsAndDataStructures.binarySearch.problems

private fun main() {
    println(mySqrt(2147395599))
}

private fun mySqrt(x: Int): Int {
    var low = 0
    var high = x

    var sqrt = 0
    while (low <= high) {
        sqrt = (low + high) / 2
        val squared: Long = sqrt.toLong() * sqrt
        if (squared == x.toLong()) return sqrt
        else if (squared > x) high = sqrt - 1
        else low = sqrt + 1
    }

    return sqrt.takeIf { it * it < x } ?: (sqrt - 1)
}
