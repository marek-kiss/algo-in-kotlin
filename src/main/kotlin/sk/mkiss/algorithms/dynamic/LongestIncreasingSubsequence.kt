package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object LongestIncreasingSubsequence {

    /**
     * get the size of the longest increasing subsequence of the given sequence
     * time complexity: Θ(n^2)
     *
     * @param sequence
     * @return
     */
    fun getSizeOfLIS(sequence: List<Int>): Int {
        val longestEndingAt = calculateLISEndingInX(sequence)
        return longestEndingAt.maxOrNull() ?: 0
    }

    private fun calculateLISEndingInX(sequence: List<Int>): List<Int> {
        val longestEndingAt = MutableList(sequence.size) { 1 }

        (sequence.indices).forEach { i ->
            (0 until i).forEach { j ->
                if (sequence[j] < sequence[i]) {
                    longestEndingAt[i] = max(longestEndingAt[i], longestEndingAt[j] + 1)
                }
            }
        }
        return longestEndingAt
    }

    fun getLIS(sequence: List<Int>): List<Int> {
        if (sequence.isEmpty()) return emptyList()

        val longestEndingAt = calculateLISEndingInX(sequence)

        val lis = mutableListOf<Int>()

        // reconstruct the LIS from longestEndingAt
        var nextIndex = getNextIndex(longestEndingAt, sequence, end = sequence.size, prevValue = Int.MAX_VALUE)
        while (nextIndex != null) {
            lis.add(sequence[nextIndex])
            nextIndex = getNextIndex(longestEndingAt, sequence, end = nextIndex, prevValue = sequence[nextIndex])
        }

        return lis.reversed()
    }

    private fun getNextIndex(longestEndingAt: List<Int>, sequence: List<Int>, end: Int, prevValue: Int): Int? {
        var maxL = 0
        var index: Int? = null

        (0 until end).forEach { i ->
            if (prevValue > sequence[i] && longestEndingAt[i] > maxL) {
                maxL = longestEndingAt[i]
                index = i
            }
        }

        return index
    }

    /**
     * get the size of the longest increasing subsequence of the given sequence
     * time complexity: O(nlogn)
     *
     * @param sequence
     * @return
     */
    fun getSizeOfLISFast(sequence: List<Int>): Int {
        if (sequence.isEmpty()) return 0

        // for each size of increasing subsequence keep the smallest ending of this sequence
        val subsequenceOfSizeEndings = mutableListOf(sequence[0])

        sequence.forEach { x ->
            if (subsequenceOfSizeEndings.last() < x) {
                subsequenceOfSizeEndings.add(x)
            } else if (subsequenceOfSizeEndings.last() > x) {
                val index = getIndexOfSmallestBigger(subsequenceOfSizeEndings, 0, subsequenceOfSizeEndings.size, x)
                subsequenceOfSizeEndings[index] = x
            }
        }

        // the last element in the subsequenceOfSizeEndings is the ending of the longest increasing subsequence
        return subsequenceOfSizeEndings.size
    }

    private fun getIndexOfSmallestBigger(sortedList: List<Int>, s: Int, e: Int, x: Int): Int {
        require(s in sortedList.indices)
        require(e <= sortedList.size)
        require(s < e)

        if (s == e - 1) return s

        val m = s + ((e - s) / 2)
        return if (sortedList[m - 1] >= x) {
            getIndexOfSmallestBigger(sortedList, s, m, x)
        } else {
            getIndexOfSmallestBigger(sortedList, m, e, x)
        }
    }
}