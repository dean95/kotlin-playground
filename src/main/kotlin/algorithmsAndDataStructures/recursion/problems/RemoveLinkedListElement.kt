package algorithmsAndDataStructures.recursion.problems

import algorithmsAndDataStructures.linkedList.ListNode

private fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(6).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5).apply {
                            next = ListNode(6)
                        }
                    }
                }
            }
        }
    }
    println(removeElements(head, 6))
}

private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return null

    val rightSideHead = removeElements(head.next, `val`)
    return if (head.`val` == `val`) {
        rightSideHead
    } else {
        head.next = rightSideHead
        head
    }
}
