package algorithmsAndDataStructures.binarySearch.problems

private fun main() {
    val nums = intArrayOf(1)
    val target = 0
    println(searchInsert(nums, target))
}

/**
 Input: nums = [1,3,5,6], target = 2
 Output: 2

 */
private fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.lastIndex

    var mid = 0
    while (low <= high) {
        mid = (low + high) / 2
        val currentValue = nums[mid]

        if (currentValue == target) return mid
        else if (currentValue < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return if (nums[mid] > target) mid else mid + 1
}
