package ctci.linkedLists

class Node<T>(var value: T, var next: Node<T>? = null ) {

    fun appendToTail(value: T) {
        val end = Node(value)
        var n = this
        while (n.next != null) {
            n = n.next!!
        }
        n.next = end
    }

    override fun toString() = buildString {
        var n: Node<T>? = this@Node
        while (n != null) {
            append(n.value)
            if (n.next != null) append(", ")
            n = n.next
        }
    }
}

fun <T> deleteNode(head: Node<T>, value: T): Node<T>? {
    if (head.value == value) return head.next

    var current: Node<T>? = head
    while (current?.next != null) {
        if (current.next!!.value == value) {
            current.next = current.next!!.next
            return head
        }
        current = current.next
    }

    return head
}
