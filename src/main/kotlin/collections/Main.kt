package collections

/** https://youtu.be/N4CpLxGJlq0 */
private fun main() {
    friendGroup.any { it.driversLicense } // true
    friendGroup.none { it.age < 18 } // false
    friendGroup.all { it.name.length < 4 } // true

    nobody.any { it.driversLicense } // false
    nobody.none { it.age < 18 } // true
    nobody.all { it.name.length < 4 } // true

    objects.chunked(3)
    objects.chunked(3) { it.reversed() }

    objects.windowed(3)
    objects.windowed(3, 2)
    objects.windowed(3, 2, true)
    objects.windowed(3, 2) { it.reversed() }

    objects.windowed(3).flatten()

    listOf("Lou", "Mel", "Cyn").flatMap {
        it.toList()
    }

    germanCities.zip(germanLicensePlates)
    germanCities zip germanLicensePlates
    germanCities.zip(germanLicensePlates) { city, plate ->
        city.uppercase() to plate.lowercase()
    }

    val citiesToPlates = germanCities.zip(germanLicensePlates)
    val (cities, plates) = citiesToPlates.unzip()

    random.zipWithNext()
    random.zipWithNext { a, b -> b - a }

    random.sum()
    random.average()
    random.reduce { acc, value -> acc * value }
    random.fold(10) { acc, value -> acc * value }
    fruits.fold(1) { acc, value -> acc * value.length }

    random.reduceRight { acc, value -> acc * value }
    random.foldRight(10) { acc, value -> acc * value }
    random.reduceOrNull { acc, value -> acc * value }
    emptyList<Int>().reduceOrNull { acc, value -> acc * value }
    emptyList<Int>().fold(1) { acc, value -> acc * value }

    random.runningReduce { acc, value -> acc * value }
    random.runningFold(10) { acc, value -> acc * value }
}

private val fruits = listOf("apple", "cherry", "banana", "orange")

private val random = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 4)

private val germanCities = listOf(
    "Aachen",
    "Bielefeld",
    "München"
)

private val germanLicensePlates = listOf(
    "AC",
    "BI",
    "M"
)

private val objects = listOf("🌱", "🚀", "💡", "🐧", "⚙️", "🤖", "📚")

private val nobody = emptyList<Person>()

private val friendGroup = listOf(
    Person("Jo", 19),
    Person("Mic", 15),
    Person("Hay", 33, true),
    Person("Cal", 25)
)

private data class Person(val name: String, val age: Int, val driversLicense: Boolean = false)
