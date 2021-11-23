package algorithmsAndDataStructures.breadthFirstSearch

private fun main() {
    val graph = mapOf(
        "You" to listOf("Bob", "Claire", "Alice"),
        "Bob" to listOf("Anuj", "Peggy"),
        "Claire" to listOf("Thom", "Jonny"),
        "Alice" to listOf("Peggy"),
        "Anuj" to emptyList(),
        "Peggy" to emptyList(),
        "Thom" to emptyList(),
        "Jonny" to emptyList()
    )

    println(findMangoSeller(graph))
}

private fun findMangoSeller(graph: Map<String, List<String>>): String? {
    val searchQueue = ArrayDeque(
        graph.getValue("You")
    )
    val searched = mutableSetOf<String>()
    while (searchQueue.isNotEmpty()) {
        val name = searchQueue.removeFirst()
        if (name !in searched) {
            if (isMangoSeller(name)) return name
            else searchQueue.addAll(graph.getValue(name))
            searched.add(name)
        }
    }

    return null
}

private fun isMangoSeller(name: String) = name.last() == 'm'
