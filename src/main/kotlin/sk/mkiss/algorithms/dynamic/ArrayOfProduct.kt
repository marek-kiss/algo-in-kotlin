package sk.mkiss.algorithms.dynamic

object ArrayOfProduct {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = MutableList<Int>(nums.size) { 1 }

        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var prev = 1
        for (i in nums.size - 2 downTo 0) {
            prev *= nums[i + 1]
            result[i] = result[i] * prev
        }

        return result.toIntArray()
    }

}