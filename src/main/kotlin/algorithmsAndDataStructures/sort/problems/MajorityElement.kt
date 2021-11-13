package algorithmsAndDataStructures.sort.problems

private fun main() {
    val nums = intArrayOf(8,8,7,7,7)
    println(majorityElement(nums))
}

// TODO Solve using sorting
private fun majorityElement(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { element ->
        map[element]?.let { map[element] = it + 1 } ?: map.put(element, 1)
    }
    return map.entries.first { it.value > (nums.size / 2) }.key
}
