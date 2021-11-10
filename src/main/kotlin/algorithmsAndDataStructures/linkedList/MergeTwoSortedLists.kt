package algorithmsAndDataStructures.linkedList

private fun main() {
    val l1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val l2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    println(mergeTwoLists(l1, l2))
}

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null
    else if (l1 == null) return l2
    else if (l2 == null) return l1

    var l1Pointer: ListNode? = l1
    var l2Pointer: ListNode? = l2

    var result: ListNode? = ListNode(-1)
    val head = result

    while (l1Pointer != null && l2Pointer != null) {
        if (l1Pointer.`val` > l2Pointer.`val`) {
            result!!.next = l2Pointer
            l2Pointer = l2Pointer.next
        } else {
            result!!.next = l1Pointer
            l1Pointer = l1Pointer.next
        }
        result = result.next
    }

    if (l1Pointer == null) result!!.next = l2Pointer
    if (l2Pointer == null) result!!.next = l1Pointer

    return head!!.next
}

private data class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "$`val`" + (next?.let { " $it" } ?: "")
    }
}
