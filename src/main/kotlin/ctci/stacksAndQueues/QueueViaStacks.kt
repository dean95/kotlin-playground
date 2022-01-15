package ctci.stacksAndQueues

private fun main() {
    val myQueue = MyQueue<Int>()
    myQueue.apply {
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }
}

private class MyQueue<T> {

    private val firstStack = ArrayDeque<T>()
    private val secondStack = ArrayDeque<T>()

    fun add(element: T) {
        firstStack.add(element)
    }

    fun remove() {
        while (firstStack.isNotEmpty()) {
            secondStack.add(firstStack.removeLast())
        }
        secondStack.removeFirst()
    }

    fun peek(): T {
        while (firstStack.isNotEmpty()) {
            secondStack.add(firstStack.removeLast())
        }
        return secondStack.first()
    }

    fun isEmpty(): Boolean = secondStack.isEmpty()
}
