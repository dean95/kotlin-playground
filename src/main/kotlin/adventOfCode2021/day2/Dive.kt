package adventOfCode2021.day2

import adventOfCode2021.utils.readInput

private fun main() {
    val input = readInput("src/main/kotlin/adventOfCode2021/day2/Input.txt")

    var horizontalPosition = 0
    var depth = 0
    var aim = 0

    input.forEach {
        val value = it.substringAfter(" ").toInt()
        when (val command = it.substringBefore(" ")) {
            "forward" -> {
                horizontalPosition += value
                depth += value * aim
            }
            "down" -> {
                aim += value
            }
            "up" -> {
                aim -= value
            }
            else -> error("Unknown command: $command")
        }
    }

    println(horizontalPosition * depth)
}
