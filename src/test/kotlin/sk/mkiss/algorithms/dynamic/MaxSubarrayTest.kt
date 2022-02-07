package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MaxSubarrayTest {

    @ParameterizedTest(name = "the max subarray of {0} should have a sum {1}")
    @MethodSource("getTestData")
    fun `test`(array: IntArray, expected: Int) {
        assertThat(MaxSubarray.maxSubArray(array)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(2), 2),
                Arguments.of(intArrayOf(-2), -2),
                Arguments.of(intArrayOf(-2, -1, -3), -1),
                Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6)
            )
        }
    }
}