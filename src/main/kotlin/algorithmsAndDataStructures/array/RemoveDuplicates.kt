package algorithmsAndDataStructures.array

private fun main() {
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicates(nums))
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 1) return nums.size

    var firstPointer = 0
    var secondPointer = 1

    while (secondPointer < nums.size) {
        if (nums[firstPointer] == nums[secondPointer]) {
            secondPointer++
        } else {
            firstPointer++
            nums[firstPointer] = nums[secondPointer]
        }
    }

    return firstPointer + 1
}
