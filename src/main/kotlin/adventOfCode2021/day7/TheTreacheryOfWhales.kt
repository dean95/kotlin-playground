package adventOfCode2021.day7

import adventOfCode2021.utils.readInput
import kotlin.math.abs
import kotlin.math.roundToInt

private fun main() {
    fun part1(input: List<Int>): Int {
        val middleIndex = input.size.let { if (it % 2 == 0) (it / 2).dec() else it / 2 }
        val cheapestPosition = input.sorted()[middleIndex]
        return input.sumOf { abs(it - cheapestPosition) }
    }

    fun part2(input: List<Int>): Int {
        val average = input.average().roundToInt()
        val cheapestPosition2 = average.dec()
        val cheapestPosition3 = average.inc()
        return minOf(
            input.sumOf { (1..abs(it - average)).sum() },
            input.sumOf { (1..abs(it - cheapestPosition2)).sum() },
            input.sumOf { (1..abs(it - cheapestPosition3)).sum() }
        )
    }

    // Test if implementation meets criteria from the description
    val testInput =
        readInput("src/main/kotlin/adventOfCode2021/day7/TestInput.txt").first().split(",").map(String::toInt)
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("src/main/kotlin/adventOfCode2021/day7/Input.txt").first().split(",").map(String::toInt)
    println(part1(input))
    println(part2(input))
}
