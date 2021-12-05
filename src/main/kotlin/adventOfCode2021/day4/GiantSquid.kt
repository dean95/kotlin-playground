package adventOfCode2021.day4

import adventOfCode2021.utils.readInput

private fun main() {
    fun part1(input: List<String>): Int {
        val winningNumbers = input.first().split(",").map(String::toInt)
        val boards = mutableListOf<Board>()
        val boardsNumbers = input.subList(2, input.size).flatMap {
            it.split(" ").filterNot(String::isBlank).map(String::toInt)
        }.toList()

        val numberOfBoards = boardsNumbers.size / 25
        repeat(numberOfBoards) { boardIndex ->
            val numbers = mutableListOf<Number>()
            repeat(5) { rowIndex ->
                repeat(5) { columnIndex ->
                    val numberIndex = 25 * boardIndex + 5 * rowIndex + columnIndex
                    numbers.add(Number(boardsNumbers[numberIndex], rowIndex, columnIndex))
                }
            }
            boards.add(Board(numbers))
        }

        for (drawnNumber in winningNumbers) {
            for (board in boards) {
                for (number in board.numbers) {
                    if (number.value == drawnNumber) {
                        number.drawn = true
                        if (board.hasWon()) {
                            return board.numbers.filter { it.drawn.not() }.sumOf(Number::value) * drawnNumber
                        }
                    }
                }

            }
        }

        error("No board has won.")
    }

    fun part2(input: List<String>): Int {
        val winningNumbers = input.first().split(",").map(String::toInt)
        val boards = mutableListOf<Board>()
        val boardsNumbers = input.subList(2, input.size).flatMap {
            it.split(" ").filterNot(String::isBlank).map(String::toInt)
        }.toList()

        val numberOfBoards = boardsNumbers.size / 25
        repeat(numberOfBoards) { boardIndex ->
            val numbers = mutableListOf<Number>()
            repeat(5) { rowIndex ->
                repeat(5) { columnIndex ->
                    val numberIndex = 25 * boardIndex + 5 * rowIndex + columnIndex
                    numbers.add(Number(boardsNumbers[numberIndex], rowIndex, columnIndex))
                }
            }
            boards.add(Board(numbers))
        }

        for (drawnNumber in winningNumbers) {
            for (board in boards) {
                for (number in board.numbers) {
                    if (number.value == drawnNumber) {
                        number.drawn = true
                        if (boards.all(Board::hasWon)) {
                            return board.numbers.filter { it.drawn.not() }.sumOf(Number::value) * drawnNumber
                        }
                    }
                }

            }
        }

        error("No board has won.")
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day4/TestInput.txt")
    check(part1(testInput) == 4512)

    val input = readInput("src/main/kotlin/adventOfCode2021/day4/Input.txt")
    println(part1(input))
    println(part2(input))
}

private data class Board(
    val numbers: MutableList<Number>
) {
    fun hasWon() = hasCompleteRow() || hasCompleteColumn()
    fun hasCompleteRow() = numbers.groupBy { it.x }.any { (_, value) -> value.all(Number::drawn) }
    fun hasCompleteColumn() = numbers.groupBy { it.y }.any { (_, value) -> value.all(Number::drawn) }
}

private data class Number(val value: Int, val x: Int, val y: Int, var drawn: Boolean = false)
