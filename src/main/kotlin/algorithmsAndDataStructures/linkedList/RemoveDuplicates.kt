package algorithmsAndDataStructures.linkedList

private fun main() {
    val head = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(3)
                }
            }
        }
    }
    println(deleteDuplicates(head))
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    var firstDistinct = current?.next

    while (firstDistinct != null) {
        if (current?.`val` == firstDistinct.`val`) {
            firstDistinct = firstDistinct.next
        } else {
            current?.next = firstDistinct
            current = current?.next
        }
    }

    if (current?.next != null && (current.`val` == current.next?.`val`)) current.next = null

    return head
}

