package algorithmsAndDataStructures.greedyAlgorithms

private fun main() {
    val statesNeeded = mutableSetOf("mt", "wa", "or", "id", "nv", "ut", "ca", "az")
    val stations = mapOf(
        "kone" to setOf("id", "nv", "ut"),
        "ktwo" to setOf("wa", "id", "mt"),
        "kthree" to setOf("or", "nv", "ca"),
        "kfour" to setOf("nv", "ut"),
        "kfive" to setOf("ca", "az")
    )
    val finalStations = mutableSetOf<String>()

    while (statesNeeded.isNotEmpty()) {
        var bestStation: String? = null
        val statesCovered = mutableSetOf<String>()

        stations.forEach { (station, statesForStation) ->
            val covered = statesNeeded intersect statesForStation
            if (covered.size > statesCovered.size) {
                bestStation = station
                statesCovered.addAll(covered)
            }
        }

        finalStations.add(bestStation!!)
        statesNeeded -= statesCovered
    }

    println(finalStations)
}
