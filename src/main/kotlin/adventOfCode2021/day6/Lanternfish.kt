package adventOfCode2021.day6

import adventOfCode2021.utils.readInput

private fun main() {
    fun part1(input: List<Int>): Int {
        var result = input.toMutableList()
        var day = 0
        while (day < 80) {
            val zeros = result.count { it == 0 }
            result = result.map { if (it == 0) 6 else it.dec() }.toMutableList()
            repeat(zeros) { result.add(8) }
            day++
        }

        return result.count()
    }

    fun part2(input: List<Int>): Long {
        val map = mutableMapOf(
            0 to 0L,
            1 to 0L,
            2 to 0L,
            3 to 0L,
            4 to 0L,
            5 to 0L,
            6 to 0L,
            7 to 0L,
            8 to 0L
        )
        input.forEach { map[it] = map[it]?.inc() ?: error("No key in the map: $it") }

        repeat(256) { index ->
            val numberOfZeros = map[0] ?: error("No key in the map: $index")
            map.keys.forEach {
                if (it != 0) {
                    map[it - 1] = map[it] ?: error("No key in the map: $it")
                }
            }
            map[8] = numberOfZeros
            map[6] = map[6]!! + numberOfZeros
        }
        return map.values.sum()
    }

    // Test if implementation meets criteria from the description
    val testInput = readInput("src/main/kotlin/adventOfCode2021/day6/TestInput.txt")
        .first()
        .split(",")
        .map(String::toInt)
    check(part1(testInput) == 5934)
    check(part2(testInput) == 26984457539)

    val input = readInput("src/main/kotlin/adventOfCode2021/day6/Input.txt")
        .first()
        .split(",")
        .map(String::toInt)
    println(part1(input))
    println(part2(input))
}
