package algorithmsAndDataStructures.recursion

import algorithmsAndDataStructures.linkedList.ListNode

private fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7)
    println(sum(nums))
}

private fun factorial(n: Int): Int {
    return if (n <= 1) 1
    else n * factorial(n - 1)
}

private fun sum(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return nums.first()

    return nums.first() + sum(nums.copyOfRange(1, nums.size))
}

private fun count(head: ListNode?): Int {
    if (head == null) return 0
    if (head.next == null) return 1

    return 1 + count(head.next)
}

private fun max(head: ListNode?): Int {
    if (head == null) return 0
    if (head.next == null) return head.`val`

    val maxRight = max(head.next)
    return if (head.`val` > maxRight) head.`val` else maxRight
}

private fun binarySearch(items: IntArray, element: Int): Int? {
    if (items.isEmpty()) return null
    if (items.size == 1) return items.first().let { if (it == element) 0 else null }

    val middleIndex = items.size / 2
    return if (element == items[middleIndex]) middleIndex
    else if (element < items[middleIndex]) binarySearch(items.copyOfRange(0, middleIndex),element)
    else binarySearch(items.copyOfRange(middleIndex, items.size), element)?.let { it + middleIndex }
}
