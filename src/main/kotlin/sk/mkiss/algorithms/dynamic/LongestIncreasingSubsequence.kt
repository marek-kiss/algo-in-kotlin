package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object LongestIncreasingSubsequence {

    fun getSizeOfLIS(sequence: List<Int>): Int {
        val longestEndingAt = MutableList(sequence.size) { 1 }

        (sequence.indices).forEach { i ->
            (0 until i).forEach { j ->
                if (sequence[j] < sequence[i]) {
                    longestEndingAt[i] = max(longestEndingAt[i], longestEndingAt[j] + 1)
                }
            }
        }
        return longestEndingAt.maxOrNull() ?: 0
    }
}