package sk.mkiss.algorithms.generator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermutationsGeneratorTest {

    @Test
    fun `should generate all permutations`() {
        assertThat(
            PermutationsGenerator.generateAll(setOf("A", "B", "C", "D"))
        ).containsExactlyInAnyOrder(
            listOf("A", "B", "C", "D"), listOf("A", "B", "D", "C"), listOf("A", "C", "B", "D"),
            listOf("A", "C", "D", "B"), listOf("A", "D", "B", "C"), listOf("A", "D", "C", "B"),
            listOf("B", "A", "C", "D"), listOf("B", "A", "D", "C"), listOf("B", "C", "A", "D"),
            listOf("B", "C", "D", "A"), listOf("B", "D", "A", "C"), listOf("B", "D", "C", "A"),
            listOf("C", "A", "B", "D"), listOf("C", "A", "D", "B"), listOf("C", "B", "A", "D"),
            listOf("C", "B", "D", "A"), listOf("C", "D", "A", "B"), listOf("C", "D", "B", "A"),
            listOf("D", "A", "B", "C"), listOf("D", "A", "C", "B"), listOf("D", "B", "A", "C"),
            listOf("D", "B", "C", "A"), listOf("D", "C", "A", "B"), listOf("D", "C", "B", "A")
        )
    }

    @Test
    fun `should handle empty set`() {
        assertThat(PermutationsGenerator.generateAll(emptySet<Int>())).isEqualTo(emptyList<List<Int>>())
    }
}