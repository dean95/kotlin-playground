package algorithmsAndDataStructures.sort.problems

private fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3
    val nums2 = intArrayOf(2, 5, 6)
    val n = 3
    merge(nums1, m, nums2, n)
    nums1.forEach { println(it) }
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var nums1Pointer = m - 1
    var nums2Pointer = n - 1

    var lastIndex = nums1.lastIndex

    while (nums1Pointer >= 0 && nums2Pointer >= 0) {
        if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
            nums1[lastIndex] = nums1[nums1Pointer]
            nums1Pointer--
        } else {
            nums1[lastIndex] = nums2[nums2Pointer]
            nums2Pointer--
        }
        lastIndex--
    }

    while (nums2Pointer >= 0) {
        nums1[lastIndex] = nums2[nums2Pointer]
        nums2Pointer--
        lastIndex--
    }
}
