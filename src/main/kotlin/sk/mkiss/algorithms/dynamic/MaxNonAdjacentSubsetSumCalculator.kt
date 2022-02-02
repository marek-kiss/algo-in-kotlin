package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object MaxNonAdjacentSubsetSumCalculator {

    /**
     * Given a list of integers, find the subset of non-adjacent elements with the maximum sum.
     * Calculate the sum of that subset. It is possible that the maximum sum is 0, the case when all elements are negative.
     *
     * original description: https://www.hackerrank.com/challenges/max-array-sum/problem
     *
     * @param inputList - list of Integers
     * @return max sum of non-adjacent elements
     */
    fun getMaxSubsetSum(inputList: List<Int>): Int {
        return getMaxSubsetSum(list = inputList, inputSize = inputList.size, maxSubsetSumMemory = mutableMapOf())

    }

    private fun getMaxSubsetSum(list: List<Int>, inputSize: Int, maxSubsetSumMemory: MutableMap<Int, Int>): Int {
        if (inputSize <= 0) return 0

        val maxWithElement = getMaxSubsetSum(list, inputSize - 2, maxSubsetSumMemory) + list[inputSize - 1]
        val maxWithoutElement = getMaxSubsetSum(list, inputSize - 1, maxSubsetSumMemory)

        return maxSubsetSumMemory.getOrPut(inputSize) { max(maxWithElement, maxWithoutElement) }
    }
}