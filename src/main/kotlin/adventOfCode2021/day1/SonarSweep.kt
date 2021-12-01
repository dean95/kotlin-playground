package adventOfCode2021.day1

import adventOfCode2021.utils.readInput

private fun main() {
    firstSolution()
    secondSolutions()
}

private fun firstSolution() {
    val input = readInput("src/main/kotlin/adventOfCode2021/day1/Input.txt").map(String::toInt)

    var counter = 0
    var firstIndex = 0
    var secondIndex = 3
    for (i in 0..input.lastIndex) {
        if (secondIndex.inc() > input.size) break
        val firstSubset = input.subList(firstIndex, secondIndex)
        val secondSubset = input.subList(firstIndex.inc(), secondIndex.inc())
        if (secondSubset.sum() > firstSubset.sum()) counter++

        firstIndex++
        secondIndex++
    }

    println(counter)
}

private fun secondSolutions() {
    val input = readInput("src/main/kotlin/adventOfCode2021/day1/Input.txt").map(String::toInt)

    // First part
    println(input.zipWithNext().count { (first, second) -> second > first })

    //Second part
    println(input.windowed(3).map { it.sum() }.zipWithNext().count { (first, second) -> second > first })
}
