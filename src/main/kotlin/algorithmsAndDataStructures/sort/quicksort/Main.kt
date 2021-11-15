package algorithmsAndDataStructures.sort.quicksort

private fun main() {
    val nums = intArrayOf(4, 10, 3, 7, 11,5)
    quicksort(nums).forEach { print("$it ") }
}

private fun quicksort(nums: IntArray): IntArray {
    if (nums.size < 2) return nums
    if (nums.size == 2) return nums.reversedArray()
    val pivot = nums.first()
    return quicksort(nums.filter { it < pivot }.toIntArray()) + pivot + quicksort(nums.filter { it > pivot }
        .toIntArray())
}
