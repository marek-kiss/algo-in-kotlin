package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FirstMissingPositiveTest {

    @Test
    fun `should throw exception if the input is empty`() {
        assertThrows<IllegalArgumentException> { FirstMissingPositive.firstMissingPositive(intArrayOf()) }
    }

    @ParameterizedTest(name = "given an array {0}, the first missing positive number is {1}")
    @MethodSource("getTestData")
    fun `should find the first missing positive number`(numbers: IntArray, expected: Int) {
        assertThat(FirstMissingPositive.firstMissingPositive(numbers)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(-5), 1),
                Arguments.of(intArrayOf(0), 1),
                Arguments.of(intArrayOf(-10, -5), 1),
                Arguments.of(intArrayOf(-10, 1), 2),
                Arguments.of(intArrayOf(1, -10), 2),
                Arguments.of(intArrayOf(0, 1, 3, 5, 7, -1, -2), 2)
            )
        }
    }
}