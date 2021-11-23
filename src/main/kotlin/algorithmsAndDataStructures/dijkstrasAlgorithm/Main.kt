package algorithmsAndDataStructures.dijkstrasAlgorithm

private fun main() {
    val graph = mapOf(
        "start" to mapOf(
            "a" to 6f,
            "b" to 2f
        ),
        "a" to mapOf(
            "fin" to 1f
        ),
        "b" to mapOf(
            "a" to 3f,
            "fin" to 5f
        ),
        "fin" to emptyMap()
    )

    val costs = mutableMapOf(
        "a" to 6f,
        "b" to 2f,
        "fin" to Float.POSITIVE_INFINITY
    )

    val parents = mutableMapOf(
        "a" to "start",
        "b" to "start",
        "fin" to null
    )

    var lowestCostNode = findLowestCostNode(costs)
    while (lowestCostNode != null) {
        val cost = costs.getValue(lowestCostNode)
        val neighbours = graph.getValue(lowestCostNode)
        neighbours.forEach { (node, neighbourCost) ->
            val newCost = cost + neighbourCost
            if (newCost < costs.getValue(node)) {
                costs[node] = newCost
                parents[node] = lowestCostNode
            }
        }
        processed.add(lowestCostNode)
        lowestCostNode = findLowestCostNode(costs)
    }

    println(costs)
    println(parents)
}

val processed = mutableSetOf<String>()

private fun findLowestCostNode(costs: Map<String, Float>): String? {
    var minValue = Float.POSITIVE_INFINITY
    var minNode: String? = null

    costs.forEach { (node, cost) ->
        if (cost < minValue && node !in processed) {
            minValue = cost
            minNode = node
        }
    }

    return minNode
}
