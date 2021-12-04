package adventOfCode2021.day3

import adventOfCode2021.utils.readInput

private fun main() {
    fun part1(input: List<Int>, bitsCount: Int): Int {
        var gammaRate = 0
        var epsilonRate = 0
        repeat(bitsCount) { index ->
            val numberOfOnes = input.map { getBitAt(it, index) }.count { it == 1 }
            val half = input.size.toFloat() / 2
            if (numberOfOnes > half) {
                gammaRate = gammaRate or (1 shl index)
            } else if (numberOfOnes < half) {
                epsilonRate = epsilonRate or (1 shl index)
            } else error("There's same number of zeros and ones.")
        }
        return gammaRate * epsilonRate
    }

    fun part2(input: List<Int>, bitsCount: Int): Int {
        val oxygenGeneratorRatingList = input.toMutableList()
        var oxygenGeneratorIndex = bitsCount - 1
        while (oxygenGeneratorRatingList.size != 1) {
            val half = oxygenGeneratorRatingList.size.toFloat() / 2
            val mostCommonValueAtPosition = if (oxygenGeneratorRatingList.map { getBitAt(it, oxygenGeneratorIndex) }
                    .count { it == 1 } >= half) 1 else 0
            oxygenGeneratorRatingList.removeAll { getBitAt(it, oxygenGeneratorIndex) != mostCommonValueAtPosition }
            oxygenGeneratorIndex--
        }

        val coTwoScrubberRatingList = input.toMutableList()
        var coTwoScrubberRatingIndex = bitsCount - 1
        while (coTwoScrubberRatingList.size != 1) {
            val half = coTwoScrubberRatingList.size.toFloat() / 2
            val leastCommonValueAtPosition = if (coTwoScrubberRatingList.map { getBitAt(it, coTwoScrubberRatingIndex) }
                    .count { it == 1 } < half) 1 else 0
            coTwoScrubberRatingList.removeAll { getBitAt(it, coTwoScrubberRatingIndex) != leastCommonValueAtPosition }
            coTwoScrubberRatingIndex--
        }
        return oxygenGeneratorRatingList.first() * coTwoScrubberRatingList.first()
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day3/TestInput.txt")
    check(part1(testInput.map { it.toInt(2) }, testInput.first().length) == 198)
    check(part2(testInput.map { it.toInt(2) }, testInput.first().length) == 230)
    val input = readInput("src/main/kotlin/adventOfCode2021/day3/Input.txt")
    println(part1(input.map { it.toInt(2) }, input.first().length))
    println(part2(input.map { it.toInt(2) }, input.first().length))
}

private fun getBitAt(number: Int, index: Int): Int = number shr index and 1
