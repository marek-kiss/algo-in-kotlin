package sk.mkiss.algorithms.graph

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class BreadthFirstSearchTest {

    private val graph =
        Node(name = "1", children = listOf(
            Node(name = "2.1"),
            Node(name = "2.2"),
            Node(name = "2.3", children = listOf(
                Node(name = "3.1", children = listOf(
                    Node(name = "4.1"),
                    Node(name = "4.2")
                ))
            )),
            Node(name = "2.4")
        )
        )

    @Test
    fun `should collect values from graph by BFS`() {
        Assertions.assertThat(BreadthFirstSearch.getValues(graph)).containsExactly(
            "1", "2.1", "2.2", "2.3", "2.4", "3.1", "4.1", "4.2"
        )
    }
}