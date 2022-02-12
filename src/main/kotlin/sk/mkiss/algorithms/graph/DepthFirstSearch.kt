package sk.mkiss.algorithms.graph

object DepthFirstSearch {

    fun getValues(node: Node): List<String> {
        return listOf(node.name) + node.children.flatMap { getValues(it) }
    }

}

