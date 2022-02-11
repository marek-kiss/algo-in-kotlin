package sk.mkiss.algorithms.graph

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DepthFirstSearchTest {

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
    fun `should collect values from graph by DFS`() {
        assertThat(DepthFirstSearch.getValues(graph)).containsExactly(
            "1", "2.1", "2.2", "2.3", "3.1", "4.1", "4.2", "2.4"
        )
    }
}