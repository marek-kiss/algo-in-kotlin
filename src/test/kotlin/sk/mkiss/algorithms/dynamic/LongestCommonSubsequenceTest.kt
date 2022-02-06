package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestCommonSubsequenceTest {

    @Test
    fun `should handle an empty list`() {
        assertThat(
            LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(
                emptyList(),
                listOf(3, 1, 1, 1, 3, 1, 2),
            )
        ).isEqualTo(0)
    }

    @Test
    fun `should handle both lists empty`() {
        assertThat(
            LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(emptyList(), emptyList())
        ).isEqualTo(0)
    }

    @Test
    fun `should return the size of the longest common subsequence`() {
        assertThat(
            LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(
                listOf(1, 2, 1, 3, 1, 4),
                listOf(3, 1, 1, 1, 3, 1, 2),
            )
        ).isEqualTo(4)
    }
}