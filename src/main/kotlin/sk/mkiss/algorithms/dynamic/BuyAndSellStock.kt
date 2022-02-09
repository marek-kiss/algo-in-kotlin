package sk.mkiss.algorithms.dynamic;

import kotlin.math.max

object BuyAndSellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    fun maxProfitFromOneDeal(prices: IntArray): Int {
        require(prices.isNotEmpty())
        require(prices.all { it >= 0 })

        var maxProfit = 0
        var maxSell = prices.last()

        (prices.size - 2 downTo 0).forEach { i ->
            maxProfit = max(maxProfit, maxSell - prices[i])
            maxSell = max(maxSell, prices[i])
        }

        return maxProfit
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    fun maxProfitFromMultipleDeals(prices: IntArray): Int {
        require(prices.isNotEmpty())
        require(prices.all { it >= 0 })

        var totalProfit = 0
        var buy = -1
        var sell = -1

        for (i in 0 .. prices.size-2) {
            if (buy == -1) {
                if (prices[i] < prices[i + 1]) {
                    buy = i
                    sell = i + 1
                }
            } else {
                if (prices[i] < prices[i + 1]) {
                    sell = i + 1
                } else if (prices[i] > prices[i + 1]) {
                    if (sell != -1) {
                        totalProfit += prices[sell] - prices[buy]
                        sell = -1
                    }
                    buy = i + 1
                }
            }
        }
        if(buy!=-1 && prices[buy]<prices.last()) {
            totalProfit += prices.last() - prices[buy]
        }
        return totalProfit
    }
}