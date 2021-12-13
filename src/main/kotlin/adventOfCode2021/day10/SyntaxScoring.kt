package adventOfCode2021.day10

import adventOfCode2021.utils.readInput

private fun main() {
    val openingToClosingMap = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')
    val closingToOpeningMap = openingToClosingMap.entries.associate { (key, value) -> value to key }
    val openingParentheses = openingToClosingMap.keys
    val closingParentheses = openingToClosingMap.values.toSet()

    fun part1(input: List<String>): Int {
        var score = 0
        input.forEach line@{ line ->
            val openedParentheses = ArrayDeque<Char>()
            line.forEach { char ->
                if (char in closingParentheses) {
                    if (openedParentheses.isEmpty()) {
                        return@line
                    } else {
                        if (openedParentheses.last() != closingToOpeningMap.getValue(char)) {
                            score += when (char) {
                                ')' -> 3
                                ']' -> 57
                                '}' -> 1197
                                '>' -> 25137
                                else -> error("Illegal closing value: $char")
                            }
                            return@line
                        } else {
                            openedParentheses.removeLast()
                        }
                    }
                } else if (char in openingParentheses) {
                    openedParentheses.add(char)
                }
            }
        }
        return score
    }

    fun part2(input: List<String>): Long {
        val lineScores = mutableListOf<Long>()
        input.forEach line@{ line ->
            val openedParentheses = ArrayDeque<Char>()
            line.forEach { char ->
                if (char in closingParentheses) {
                    if (openedParentheses.isEmpty()) {
                        return@line
                    } else {
                        if (openedParentheses.last() != closingToOpeningMap.getValue(char)) {
                            return@line
                        } else {
                            openedParentheses.removeLast()
                        }
                    }
                } else if (char in openingParentheses) {
                    openedParentheses.add(char)
                }
            }
            val missingClosingChars = mutableListOf<Char>()
            while (openedParentheses.isNotEmpty()) {
                missingClosingChars.add(openingToClosingMap.getValue(openedParentheses.removeLast()))
            }
            var lineScore = 0L
            missingClosingChars.forEach { char ->
                lineScore *= 5
                lineScore += when (char) {
                    ')' -> 1
                    ']' -> 2
                    '}' -> 3
                    '>' -> 4
                    else -> error("Illegal closing value: $char")
                }
            }
            lineScores.add(lineScore)
        }
        lineScores.sort()
        return lineScores[lineScores.lastIndex / 2]
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day10/TestInput.txt")
    check(part1(testInput) == 26397)
    check(part2(testInput) == 288957L)

    val input = readInput("src/main/kotlin/adventOfCode2021/day10/Input.txt")
    println(part1(input))
    println(part2(input))
}
