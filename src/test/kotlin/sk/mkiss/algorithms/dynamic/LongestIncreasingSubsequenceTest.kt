package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LongestIncreasingSubsequenceTest {

    @Test
    fun `should handle empty input`() {
        assertThat(LongestIncreasingSubsequence.getSizeOfLIS(emptyList())).isEqualTo(0)
    }

    @ParameterizedTest(name = "the size of LIC in {0} should be {1}")
    @MethodSource("getTestData")
    fun `should return correct size of the longest increasing subsequence`(sequence: List<Int>, expected: Int) {
        assertThat(LongestIncreasingSubsequence.getSizeOfLIS(sequence)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(2), 1),
                Arguments.of(listOf(2, 4, 3, 7, 4, 5), 4),
                Arguments.of(listOf(2, 4, 3, 7, 4, 5, 5, 4), 4),
                Arguments.of(listOf(2, 4, 3, 7, 4, 5, 5, 4, 6), 5),
                Arguments.of(listOf(5, 4, 3, 2, 1, 0), 1)
            )
        }
    }
}