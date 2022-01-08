package ctci.linkedLists.questions

import ctci.linkedLists.Node

private fun main() {
    val head = Node(1, next = Node(2, next = Node(1, next = Node(1, next = Node(1)))))
    println(head)
    removeDuplicates(head)
    println(head)
}

private fun removeDuplicates(head: Node<Int>) {
    val values = mutableSetOf(head.value)

    var n: Node<Int>? = head
    while (n?.next != null) {
        if (n.next!!.value in values) {
            n.next = n.next!!.next
        } else {
            values.add(n.next!!.value)
            n = n.next
        }
    }
}
