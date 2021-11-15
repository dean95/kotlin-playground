package algorithmsAndDataStructures.sort.selectionSort

private fun main() {
    val input = intArrayOf()
    println(selectionSort(input).toList())
}

private fun selectionSort(input: IntArray): IntArray {
    val mutableInput = input.toMutableList()
    val newArray = IntArray(input.size)

    repeat(mutableInput.size) {
        val smallest = findSmallest(mutableInput.toIntArray())
        newArray[it] = smallest
        mutableInput.remove(smallest)
    }
    return newArray
}

private fun findSmallest(input: IntArray): Int {
    var smallest = input.first()
    input.forEach { if (it < smallest) smallest = it }

    return smallest
}
