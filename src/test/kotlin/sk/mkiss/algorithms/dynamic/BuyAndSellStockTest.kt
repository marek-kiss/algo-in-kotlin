package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BuyAndSellStockTest {

    @Test
    fun `should throw exception if the input is empty`() {
        assertThrows<IllegalArgumentException> { BuyAndSellStock.maxProfit(intArrayOf()) }
    }

    @Test
    fun `should throw exception if a price is negative`() {
        assertThrows<IllegalArgumentException> { BuyAndSellStock.maxProfit(intArrayOf(5, 4, 9, -1, 9)) }
    }

    @ParameterizedTest(name = "given prices {0}, the max profit should be {1}")
    @MethodSource("getTestData")
    fun `should calculate the max profit for given prices`(prices: IntArray, expectedProfit: Int) {
        assertThat(BuyAndSellStock.maxProfit(prices)).isEqualTo(expectedProfit)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(5), 0),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), 0),
                Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 5),
            )
        }
    }
}