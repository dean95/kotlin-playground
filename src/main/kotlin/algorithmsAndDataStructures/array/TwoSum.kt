package algorithmsAndDataStructures.array

private fun main() {
    val nums = intArrayOf(3, 3)
    val target = 6
    println(twoSum(nums, target).toList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed { i, firstElement ->
        for (j in (i + 1)..nums.lastIndex) {
            if (firstElement + nums[j] == target) return intArrayOf(i, j)
        }
    }

    throw IllegalStateException("Only one valid answer exists")
}
