package algorithmsAndDataStructures.binarySearch

private fun main() {
    val items = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val element = 20
    println(binarySearch(items, element))
}

private fun binarySearch(items: IntArray, element: Int): Int? {
    var low = 0
    var high = items.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2
        if (items[mid] == element) return mid
        if (items[mid] < element) {
            low = mid + 1
        } else if (items[mid] > element) {
            high = mid - 1
        }
    }

    return null
}
