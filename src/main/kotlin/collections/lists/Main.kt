package collections.lists

import kotlin.random.Random

private fun main() {
    /** Creating lists */
    listOf(1, 2, 3, 4, 5)

    List(5) { "No. $it" }

    "text".toList()

    mapOf(
        1 to "Gold",
        2 to "Silver",
        3 to "Bronze"
    ).toList()

    generateSequence {
        Random.nextInt(100).takeIf { it > 30 }
    }.toList()

    (0..10).toList()

    val mutableList = mutableListOf(1, 2, 3)
    val otherList = mutableList.toList()
    mutableList[0] = 9


    /** Accessing elements */
    val myList = listOf(1, 2, 3)
    myList[1]
    myList.getOrNull(3)
    myList.getOrElse(3) {
        println("There's no index $it")
        -1
    }
    val listOfNullableItems = listOf(1, 2, null, 4)
    val item = listOfNullableItems[0] ?: 0

    /** Getting multiple items: slice */
    val myList2 = listOf(1, 2, 3, 4, 5)
    myList2.slice(listOf(0, 2, 4))
    myList2.slice(0..myList2.lastIndex step 2)
    myList2.slice(2 downTo 0)

    /** Mutable lists */
    val m = mutableListOf(1, 2, 3)
    (0..10).toMutableList()
    listOf(1, 2, 3).toMutableList()

    m.add(4)
    m += 4
    m.add(2, 10)
    m += listOf(5, 6, 7)

    m -= 3
    m.remove(3)
    m -= listOf(1, 4)
    m.removeAt(1)
    m[0] = 100

    m.fill(0)
    m.clear()

    /** Shuffling, sorting, reversing */
    m.shuffled()
    m.shuffle()
    m.sorted()
    m.sort()
    m.reversed()
    m.reverse()

    /** Retaining or removing elements */
    m.removeAll { it < 5 }
    m.retainAll { it < 5 }

    /** Views on lists */
    m.subList(0 ,2)
    m.asReversed()
}
