package sk.mkiss.algorithms.dynamic

import kotlin.math.abs


object FirstMissingPositive {

    fun firstMissingPositive(nums: IntArray): Int {
        require(nums.isNotEmpty())
        var l = 0
        var r = nums.size - 1

        while (l < r) {
            if (nums[r] <= 0) r--
            else if (nums[l] > 0) l++
            else {
                val p = nums[l]
                nums[l] = nums[r]
                nums[r] = p
            }
        }

        if (nums[l] <= 0) return 1
        for (i in 0..l) {
            if (abs(nums[i]) -1 in nums.indices) nums[abs(nums[i]) - 1] = -1 * nums[abs(nums[i]) - 1]
        }
        for (i in 0..l) {
            if (nums[i] > 0) return i + 1
        }

        return l + 2
    }
}