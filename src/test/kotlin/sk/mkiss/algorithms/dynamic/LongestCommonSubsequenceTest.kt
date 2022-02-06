package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LongestCommonSubsequenceTest {

    @Test
    fun `getSizeOfLongestCommonSubsequence - should handle an empty list`() {
        assertThat(
            LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(
                emptyList(),
                listOf(3, 1, 1, 1, 3, 1, 2),
            )
        ).isEqualTo(0)
    }

    @Test
    fun `getSizeOfLongestCommonSubsequence - should handle both lists empty`() {
        assertThat(LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(emptyList(), emptyList())).isEqualTo(0)
    }

    @Test
    fun `getSizeOfLongestCommonSubsequence - should return the correct size`() {
        assertThat(
            LongestCommonSubsequence.getSizeOfLongestCommonSubsequence(
                listOf(1, 2, 1, 3, 1, 4),
                listOf(3, 1, 1, 1, 3, 1, 2),
            )
        ).isEqualTo(4)
    }

    @Test
    fun `getLongestCommonSubsequence - handles empty list`() {
        assertThat(LongestCommonSubsequence.getLongestCommonSubsequence(emptyList(), listOf(3))).isEmpty()
    }

    @Test
    fun `getLongestCommonSubsequence - returns LCS`() {
        assertThat(
            LongestCommonSubsequence.getLongestCommonSubsequence(
                listOf(1, 2, 1, 3, 1, 4, 5, 1, 1),
                listOf(3, 1, 1, 1, 3, 1, 2, 4, 1, 1, 1, 1, 5),
            )
        ).isEqualTo(
            listOf(1, 1, 3, 1, 4, 1, 1)
        )
    }
}