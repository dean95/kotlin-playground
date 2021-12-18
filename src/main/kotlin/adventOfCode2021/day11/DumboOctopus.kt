package adventOfCode2021.day11

import adventOfCode2021.utils.readInput

private fun main() {
    fun part1(input: List<String>): Int {
        val inputMatrix = mutableListOf<MutableList<Int>>()
        input.forEach { value ->
            val row = mutableListOf<Int>()
            value.forEach { char ->
                row.add(char.toString().toInt())
            }
            inputMatrix.add(row)
        }

        var flashCount = 0
        repeat(100) {
            val flashing: MutableSet<Pair<Int, Int>> = mutableSetOf()
            inputMatrix.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { columnIndex, value ->
                    if (value < 9) {
                        if (rowIndex to columnIndex !in flashing) inputMatrix[rowIndex][columnIndex] = value.inc()
                    } else increaseAdjacent(inputMatrix, rowIndex, columnIndex, flashing)
                }
            }
            flashCount += flashing.size
        }
        return flashCount
    }

    fun part2(input: List<String>): Int {
        val inputMatrix = mutableListOf<MutableList<Int>>()
        input.forEach { value ->
            val row = mutableListOf<Int>()
            value.forEach { char ->
                row.add(char.toString().toInt())
            }
            inputMatrix.add(row)
        }

        var stepCount = 1
        while (true) {
            val flashing: MutableSet<Pair<Int, Int>> = mutableSetOf()
            inputMatrix.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { columnIndex, value ->
                    if (value < 9) {
                        if (rowIndex to columnIndex !in flashing) inputMatrix[rowIndex][columnIndex] = value.inc()
                    } else increaseAdjacent(inputMatrix, rowIndex, columnIndex, flashing)
                }
            }

            if (flashing.size == 100) break
            stepCount++
        }
        return stepCount
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day11/TestInput.txt")
    check(part1(testInput) == 1656)
    check(part2(testInput) == 195)


    val input = readInput("src/main/kotlin/adventOfCode2021/day11/Input.txt")
    println(part1(input))
    println(part2(input))
}

private fun increaseAdjacent(
    input: MutableList<MutableList<Int>>,
    rowIndex: Int,
    columnIndex: Int,
    flashing: MutableSet<Pair<Int, Int>>
) {
    if (input[rowIndex][columnIndex] < 9) input[rowIndex][columnIndex] = input[rowIndex][columnIndex].inc()
    else {
        input[rowIndex][columnIndex] = 0
        flashing.add(rowIndex to columnIndex)
        for (i in -1..1) {
            for (j in -1..1) {
                if ((rowIndex + i) to (columnIndex + j) in flashing) continue
                input.getOrNull(rowIndex + i)?.getOrNull(columnIndex + j)?.let {
                    increaseAdjacent(input, rowIndex + i, columnIndex + j, flashing)
                }
            }
        }
    }
}
