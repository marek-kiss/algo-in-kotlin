package sk.mkiss.algorithms.graph

import java.util.*

object BreadthFirstSearch {

    fun getValues(node: Node): List<String> {
        val result = mutableListOf<String>()

        val queue: Queue<Node> = LinkedList()
        queue.add(node)

        while(queue.isNotEmpty()) {
            queue.poll()!!.also { headNode ->
                result.add(headNode.name)
                queue.addAll(headNode.children)
            }
        }
        return result
    }
}