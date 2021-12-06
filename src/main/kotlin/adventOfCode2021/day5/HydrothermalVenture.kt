package adventOfCode2021.day5

import adventOfCode2021.utils.readInput
import kotlin.math.abs

private fun main() {
    fun part1(input: List<String>): Int {
        val ventLines = mutableListOf<VentLine>()
        input.forEach {
            val (startX, startY) = it.substringBefore(" -> ").split(",").map(String::toInt)
            val (endX, endY) = it.substringAfter(" -> ").split(",").map(String::toInt)
            val startPoint = Point(startX, startY)
            val endPoint = Point(endX, endY)
            ventLines.add(VentLine(startPoint, endPoint))
        }

        val diagram = mutableMapOf<Point, Int>()
        ventLines.filter {
            it.firstEnd.x == it.secondEnd.x || it.firstEnd.y == it.secondEnd.y
        }.forEach { ventLine ->
            ventLine.run {
                if (firstEnd.isHorizontallyAlignedWith(secondEnd)) {
                    val range =
                        if (firstEnd <= secondEnd) firstEnd.y..secondEnd.y else firstEnd.y downTo secondEnd.y
                    for (i in range) {
                        val point = Point(firstEnd.x, i)
                        diagram[point] = diagram[point]?.inc() ?: 1
                    }
                } else if (firstEnd.isVerticallyAlignedWith(secondEnd)) {
                    val range =
                        if (firstEnd <= secondEnd) firstEnd.x..secondEnd.x else firstEnd.x downTo secondEnd.x
                    for (i in range) {
                        val point = Point(i, firstEnd.y)
                        diagram[point] = diagram[point]?.inc() ?: 1
                    }
                }
            }
        }

        return diagram.values.count { it >= 2 }
    }

    fun part2(input: List<String>): Int {
        val ventLines = mutableListOf<VentLine>()
        input.forEach {
            val (startX, startY) = it.substringBefore(" -> ").split(",").map(String::toInt)
            val (endX, endY) = it.substringAfter(" -> ").split(",").map(String::toInt)
            val startPoint = Point(startX, startY)
            val endPoint = Point(endX, endY)
            ventLines.add(VentLine(startPoint, endPoint))
        }

        val diagram = mutableMapOf<Point, Int>()
        ventLines.forEach { ventLine ->
            ventLine.run {
                if (firstEnd.isHorizontallyAlignedWith(secondEnd)) {
                    val range =
                        if (firstEnd <= secondEnd) firstEnd.y..secondEnd.y else firstEnd.y downTo secondEnd.y
                    for (i in range) {
                        val point = Point(firstEnd.x, i)
                        diagram[point] = diagram[point]?.inc() ?: 1
                    }
                } else if (firstEnd.isVerticallyAlignedWith(secondEnd)) {
                    val range =
                        if (firstEnd <= secondEnd) firstEnd.x..secondEnd.x else firstEnd.x downTo secondEnd.x
                    for (i in range) {
                        val point = Point(i, firstEnd.y)
                        diagram[point] = diagram[point]?.inc() ?: 1
                    }
                } else if (firstEnd.isDiagonallyAlignedWith(secondEnd)) {
                    if (firstEnd <= secondEnd) {
                        var x = firstEnd.x
                        var y = firstEnd.y
                        if (firstEnd.y < secondEnd.y) {
                            while (x <= secondEnd.x && y <= secondEnd.y) {
                                val point = Point(x, y)
                                diagram[point] = diagram[point]?.inc() ?: 1
                                x++
                                y++
                            }
                        } else {
                            while (x <= secondEnd.x && y >= secondEnd.y) {
                                val point = Point(x, y)
                                diagram[point] = diagram[point]?.inc() ?: 1
                                x++
                                y--
                            }
                        }
                    } else {
                        var x = firstEnd.x
                        var y = firstEnd.y
                        if (firstEnd.y > secondEnd.y) {
                            while (x >= secondEnd.x && y >= secondEnd.y) {
                                val point = Point(x, y)
                                diagram[point] = diagram[point]?.inc() ?: 1
                                x--
                                y--
                            }
                        } else {
                            while (x >= secondEnd.x && y <= secondEnd.y) {
                                val point = Point(x, y)
                                diagram[point] = diagram[point]?.inc() ?: 1
                                x--
                                y++
                            }
                        }
                    }
                }
            }
        }

        return diagram.values.count { it >= 2 }
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day5/TestInput.txt")
    check(part1(testInput) == 5)

    val input = readInput("src/main/kotlin/adventOfCode2021/day5/Input.txt")
    println(part1(input))
    println(part2(input))
}

data class Point(val x: Int, val y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        if (this.x < other.x) return -1
        if (this.x > other.x) return 1
        if (this.y < other.y) return -1
        if (this.y > other.y) return 1
        return 0
    }

    fun isHorizontallyAlignedWith(other: Point) = x == other.x

    fun isVerticallyAlignedWith(other: Point) = y == other.y

    fun isDiagonallyAlignedWith(other: Point) = abs(x - other.x) == abs(y - other.y)
}

data class VentLine(val firstEnd: Point, val secondEnd: Point)
