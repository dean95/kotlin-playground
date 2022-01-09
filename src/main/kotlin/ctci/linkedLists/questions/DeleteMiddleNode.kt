package ctci.linkedLists.questions

import ctci.linkedLists.Node

private fun main() {
    val nodeToRemove = Node(4, next = Node(5))
    val head = Node(1, next = Node(2, next = Node(3, next = nodeToRemove)))
    println(head)
    deleteMiddleNode(nodeToRemove)
    println(head)
}

private fun deleteMiddleNode(nodeToRemove: Node<Int>) {
    nodeToRemove.value = nodeToRemove.next!!.value
    nodeToRemove.next = nodeToRemove.next!!.next
}
