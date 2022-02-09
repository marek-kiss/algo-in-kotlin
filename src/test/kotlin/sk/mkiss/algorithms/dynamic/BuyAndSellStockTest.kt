package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BuyAndSellStockTest {

    @Test
    fun `maxProfitFromOneDeal - should throw exception if the input is empty`() {
        assertThrows<IllegalArgumentException> { BuyAndSellStock.maxProfitFromOneDeal(intArrayOf()) }
    }

    @Test
    fun `maxProfitFromOneDeal - should throw exception if a price is negative`() {
        assertThrows<IllegalArgumentException> { BuyAndSellStock.maxProfitFromOneDeal(intArrayOf(5, 4, 9, -1, 9)) }
    }

    @ParameterizedTest(name = "given prices {0}, the max profit should be {1}")
    @MethodSource("getTestDataForMaxProfitFromOneDeal")
    fun `maxProfitFromOneDeal - should calculate the profit for the best possible deal`(
        prices: IntArray,
        expectedProfit: Int
    ) {
        assertThat(BuyAndSellStock.maxProfitFromOneDeal(prices)).isEqualTo(expectedProfit)
    }

    @Test
    fun `maxProfitFromMultipleDeals - should throw exception if the input is empty`() {
        assertThrows<IllegalArgumentException> { BuyAndSellStock.maxProfitFromMultipleDeals(intArrayOf()) }
    }

    @Test
    fun `maxProfitFromMultipleDeals - should throw exception if a price is negative`() {
        assertThrows<IllegalArgumentException> {
            BuyAndSellStock.maxProfitFromMultipleDeals(
                intArrayOf(
                    5,
                    4,
                    9,
                    -1,
                    9
                )
            )
        }
    }

    @ParameterizedTest(name = "given prices {0}, the max total profit should be {1}")
    @MethodSource("getTestDataForMaxProfitFromMultipleDeals")
    fun `maxProfitFromMultipleDeals - should calculate the max total possible profit`(
        prices: IntArray,
        expectedProfit: Int
    ) {
        assertThat(BuyAndSellStock.maxProfitFromMultipleDeals(prices)).isEqualTo(expectedProfit)
    }

    companion object {
        @JvmStatic
        fun getTestDataForMaxProfitFromOneDeal(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(5), 0),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), 0),
                Arguments.of(intArrayOf(7, 1, 5, 3, 6, 4), 5),
            )
        }

        @JvmStatic
        fun getTestDataForMaxProfitFromMultipleDeals(): List<Arguments> {
            return listOf(
                Arguments.of(intArrayOf(5), 0),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), 0),
                Arguments.of(intArrayOf(5, 4, 3, 2, 3), 1),
                Arguments.of(intArrayOf(9, 8, 7, 6, 4, 5, 7, 3, 2, 4, 4), 5)
            )
        }
    }
}