package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MaxNonAdjacentSubsetSumCalculatorTest {

    @Test
    fun `should handle empty input`() {
        assertThat(MaxNonAdjacentSubsetSumCalculator.getMaxSubsetSum(emptyList())).isEqualTo(0)
    }

    @Test
    fun `should return 0 when all elements are negative `() {
        assertThat(MaxNonAdjacentSubsetSumCalculator.getMaxSubsetSum(listOf(-1, -5, -6))).isEqualTo(0)
    }

    @Test
    fun `should calculate correct max sum of non-adjacent elements`() {
        assertThat(MaxNonAdjacentSubsetSumCalculator.getMaxSubsetSum(listOf(2, 1, 5, 8, 4))).isEqualTo(11)
        assertThat(MaxNonAdjacentSubsetSumCalculator.getMaxSubsetSum(listOf(3, 5, -7, 8, 10))).isEqualTo(15)
    }

}