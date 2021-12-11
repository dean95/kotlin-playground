package adventOfCode2021.day8

import adventOfCode2021.utils.readInput

private fun main() {
    fun part2(input: List<Input>): Int = input.sumOf { it ->
        val digitToPatternMap = mutableMapOf<Int, String>()
        it.signalPatterns
            .forEach { pattern ->
                when (pattern.length) {
                    2 -> digitToPatternMap[1] = pattern
                    3 -> digitToPatternMap[7] = pattern
                    4 -> digitToPatternMap[4] = pattern
                    7 -> digitToPatternMap[8] = pattern
                }
            }

        it.signalPatterns
            .forEach { pattern ->
                when (pattern.length) {
                    6 -> {
                        if (digitToPatternMap.getValue(1).all { it in pattern } && digitToPatternMap.getValue(4)
                                .all { it in pattern } && digitToPatternMap.getValue(7).all { it in pattern })
                            digitToPatternMap[9] = pattern
                        else if (digitToPatternMap.getValue(1).all { it in pattern } && digitToPatternMap.getValue(7)
                                .all { it in pattern })
                            digitToPatternMap[0] = pattern
                        else digitToPatternMap[6] = pattern
                    }
                    5 -> {
                        if (digitToPatternMap.getValue(1).all { it in pattern }) digitToPatternMap[3] = pattern
                        else if (pattern.toCharArray()
                                .intersect(digitToPatternMap.getValue(4).toCharArray().asIterable()).size == 2
                        ) digitToPatternMap[2] = pattern
                        else digitToPatternMap[5] = pattern
                    }
                }
            }

        val patternToDigitMap =
            digitToPatternMap.entries.associate { (key, value) ->
                value.toCharArray().sortedArray().concatToString() to key
            }

        val digitsString = it.outputDigits.fold("") { acc, value ->
            acc + patternToDigitMap.getValue(value.toCharArray().sortedArray().concatToString())
        }
        digitsString.toInt()
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day8/TestInput.txt").map {
        val (signalPatternsString, outputDigitsString) = it.split("|")
        Input(
            signalPatternsString.split(" ").filterNot(String::isBlank),
            outputDigitsString.split(" ").filterNot(String::isBlank)
        )
    }
    check(part2(testInput) == 61229)

    val input = readInput("src/main/kotlin/adventOfCode2021/day8/Input.txt").map {
        val (signalPatternsString, outputDigitsString) = it.split("|")
        Input(
            signalPatternsString.split(" ").filterNot(String::isBlank),
            outputDigitsString.split(" ").filterNot(String::isBlank)
        )
    }
    println(part2(input))
}

private data class Input(
    val signalPatterns: List<String>,
    val outputDigits: List<String>
)
