package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object MaxSubarray {

    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]

        (1 until nums.size).forEach { i ->
            nums[i] = max(nums[i], nums[i] + nums[i - 1])
            maxSum = max(maxSum, nums[i])
        }
        return maxSum
    }
}
