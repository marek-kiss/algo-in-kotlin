package sk.mkiss.algorithms.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubsetsGeneratorTest {

    @Test
    fun `should generate all subsets`() {
        assertThat(
            SubsetsGenerator.generateAll(setOf("A", "B", "C", "D"))
        ).containsExactlyInAnyOrder(
            setOf(),
            setOf("A"),
            setOf("B"),
            setOf("C"),
            setOf("D"),
            setOf("A", "B"),
            setOf("A", "C"),
            setOf("A", "D"),
            setOf("B", "C"),
            setOf("B", "D"),
            setOf("C", "D"),
            setOf("A", "B", "C"),
            setOf("A", "B", "D"),
            setOf("A", "C", "D"),
            setOf("B", "C", "D"),
            setOf("A", "B", "C", "D"),
        )
    }

    @Test
    fun `should handle empty set`() {
        assertThat(SubsetsGenerator.generateAll(emptySet<Int>())).isEqualTo(listOf(emptySet<Int>()))
    }
}