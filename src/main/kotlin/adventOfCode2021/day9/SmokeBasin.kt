package adventOfCode2021.day9

import adventOfCode2021.utils.readInputAsText

private fun main() {
    fun part1(input: List<Int>, lineLength: Int) = input.filterIndexed { index, value ->
        val leftNeighbour = input.getOrNull(index.dec())?.let { value < it } ?: true
        val rightNeighbour = input.getOrNull(index.inc())?.let { value < it } ?: true
        val topNeighbour = input.getOrNull(index - lineLength)?.let { value < it } ?: true
        val bottomNeighbour = input.getOrNull(index + lineLength)?.let { value < it } ?: true

        leftNeighbour && rightNeighbour && topNeighbour && bottomNeighbour
    }.sumOf { it.inc() }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description
    val testInput =
        readInputAsText("src/main/kotlin/adventOfCode2021/day9/TestInput.txt").toCharArray().filter { it.isDigit() }
            .map { it.toString().toInt() }
    check(part1(testInput, 10) == 15)

    val input = readInputAsText("src/main/kotlin/adventOfCode2021/day9/Input.txt").toCharArray().filter { it.isDigit() }
        .map { it.toString().toInt() }
    println(part1(input, 100))
//    println(part2(input))
}
