package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxLikeTimeCoefficientSolutionTest {

    @ParameterizedTest(name = "given satisfactions {0}, the max like-time coefficient is {1}")
    @MethodSource("getTestData")
    fun `should calculate the max like-time coefficient`(satisfactions: IntArray, expected: Int) {
        assertThat(MaxLikeTimeCoefficientSolution.maxSatisfaction(satisfactions)).isEqualTo(expected)
        assertThat(MaxLikeTimeCoefficientSolution.maxSatisfaction(intArrayOf(-10, -5, -1, 0, 1, 1))).isEqualTo(6)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(), 0),
                Arguments.of(intArrayOf(-10, -5, -1), 0),
                Arguments.of(intArrayOf(-10, -5, -1, 0, 2), 5),
                Arguments.of(intArrayOf(-10, -5, -1, 0, 1, 1), 6),
                Arguments.of(intArrayOf(0, -1, -5, 1, 1, -10), 6),
                Arguments.of(intArrayOf(-10, -5, 0, 1, 1), 5)
            )
        }
    }
}