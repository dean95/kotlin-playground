package ctci.linkedLists.questions

import ctci.linkedLists.Node

private fun main() {
    val head = Node(1, next = Node(2, next = Node(3, next = Node(4, next = Node(5)))))
    getKthToLast(head, 1)
}

//private fun getKthToLast(head: Node<Int>, k: Int): Int {
//    val stack = ArrayDeque<Int>()
//    var n = head
//    stack.add(n.value)
//    while (n.next != null) {
//        stack.add(n.next!!.value)
//        n = n.next!!
//    }
//    repeat(k) {
//        stack.removeLast()
//    }
//    return stack.last()
//}

//private fun getKthToLast(head: Node<Int>, k: Int): Int {
//    var n = head
//    var size = 1
//    while (n.next != null) {
//        size++
//        n = n.next!!
//    }
//    n = head
//    repeat(size.dec() - k) {
//        n = n.next!!
//    }
//    return n.value
//}

//private fun getKthToLast(head: Node<Int>, k: Int): Int {
//    if (head.next == null) {
//        println("Last is: ${head.value}")
//        return 0
//    }
//    val index = getKthToLast(head.next!!, k) + 1
//    if (index == k) println("${k}th to last is: ${head.value}")
//    return index
//}

private fun getKthToLast(head: Node<Int>, k: Int): Int {
    var firstPointer = head
    var secondPointer = head
    var counter = 0
    while (secondPointer.next != null) {
        secondPointer = secondPointer.next!!
        if (counter >= k) firstPointer = firstPointer.next!!
        counter++
    }
    return firstPointer.value
}
