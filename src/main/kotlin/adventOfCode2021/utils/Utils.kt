package adventOfCode2021.utils

import java.io.File

fun readInput(name: String) = File(name).readLines()

fun readInputAsText(name: String) = File(name).readText()

fun readInputAsInts(name: String) = File(name).readLines().map(String::toInt)
