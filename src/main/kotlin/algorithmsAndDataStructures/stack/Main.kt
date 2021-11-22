package algorithmsAndDataStructures.stack

private fun main() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack)

    stack.pop()
    stack.pop()

    println(stack)
}

private class Stack<T> {
    private val elements = arrayListOf<T>()

    fun push(element: T) = elements.add(element)

    fun pop() = if (elements.isEmpty()) null else elements.removeLast()

    override fun toString(): String {
        return elements.reversed().joinToString()
    }
}
