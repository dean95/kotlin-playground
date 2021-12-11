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

    val processed = mutableSetOf<Int>()
    fun findBasinSize(input: List<Int>, index: Int, lineLength: Int): Int {
        val leftBasinSize = if (index % lineLength == 0) 0 else input.getOrNull(index.dec())?.let {
            if (index.dec() in processed || it == 9 || it <= input[index]) {
                processed.add(index)
                0
            } else 1 + findBasinSize(input, index.dec(), lineLength)
        } ?: 0
        val rightBasinSize = if (index.inc() % lineLength == 0) 0 else input.getOrNull(index.inc())?.let {
            if (index.inc() in processed || it == 9 || it <= input[index]) {
                processed.add(index)
                0
            } else 1 + findBasinSize(input, index.inc(), lineLength)
        } ?: 0
        val topBasinSize = input.getOrNull(index - lineLength)?.let {
            if (index - lineLength in processed || it == 9 || it <= input[index]) {
                processed.add(index)
                0
            } else 1 + findBasinSize(input, index - lineLength, lineLength)
        } ?: 0
        val bottomBasinSize = input.getOrNull(index + lineLength)?.let {
            if (index + lineLength in processed || it == 9 || it <= input[index]) {
                processed.add(index)
                0
            } else 1 + findBasinSize(input, index + lineLength, lineLength)
        } ?: 0
        return leftBasinSize + rightBasinSize + topBasinSize + bottomBasinSize
    }

    fun part2(input: List<Int>, lineLength: Int): Int = input.mapIndexed { index, value ->
        val leftNeighbour = input.getOrNull(index.dec())?.let { value < it } ?: true
        val rightNeighbour = input.getOrNull(index.inc())?.let { value < it } ?: true
        val topNeighbour = input.getOrNull(index - lineLength)?.let { value < it } ?: true
        val bottomNeighbour = input.getOrNull(index + lineLength)?.let { value < it } ?: true

        if (leftNeighbour && rightNeighbour && topNeighbour && bottomNeighbour) index else -1
    }.filterNot { it < 0 }.map { index -> findBasinSize(input, index, lineLength).inc() }.sortedDescending().take(3)
        .reduce { acc, i -> acc * i }

    // Test if implementation meets criteria from the description
    val testInput =
        readInputAsText("src/main/kotlin/adventOfCode2021/day9/TestInput.txt").toCharArray().filter { it.isDigit() }
            .map { it.toString().toInt() }
    check(part1(testInput, 10) == 15)
    check(part2(testInput, 10) == 1134)

    val input = readInputAsText("src/main/kotlin/adventOfCode2021/day9/Input.txt").toCharArray().filter { it.isDigit() }
        .map { it.toString().toInt() }
    println(part1(input, 100))
    println(part2(input, 100))
}
