package adventOfCode2021

import adventOfCode2021.utils.readInput

private fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day3/TestInput.txt")
    check(part1(testInput) == 1)

    val input = readInput("src/main/kotlin/adventOfCode2021/day3/Input.txt")
    println(part1(input))
    println(part2(input))
}
