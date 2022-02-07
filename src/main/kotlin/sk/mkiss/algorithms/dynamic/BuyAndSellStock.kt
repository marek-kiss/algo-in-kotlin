package sk.mkiss.algorithms.dynamic;

import kotlin.math.max

object BuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        require(prices.isNotEmpty())
        require(prices.all { it > 0 })

        var maxProfit = 0
        var maxSell = prices.last()

        (prices.size - 2 downTo 0).forEach { i ->
            maxProfit = max(maxProfit, maxSell - prices[i])
            maxSell = max(maxSell, prices[i])
        }

        return maxProfit
    }
}