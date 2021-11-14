package algorithmsAndDataStructures.recursion.problems

import algorithmsAndDataStructures.linkedList.ListNode

private fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    println(reverseList(head))
}

private fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null

    var newHead = head
    if (head.next != null) {
        newHead = reverseList(head.next)
        head.next?.next = head
    }
    head.next = null

    return newHead
}
