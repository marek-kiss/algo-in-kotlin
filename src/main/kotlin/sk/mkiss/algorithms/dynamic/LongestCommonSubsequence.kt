package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object LongestCommonSubsequence {

    fun getSizeOfLongestCommonSubsequence(a: List<Int>, b: List<Int>): Int {
        val d = mutableMapOf<Pair<Int, Int>, Int>()
        lcs(a, b, a.size, b.size, d)
        return d[Pair(a.size, b.size)]!!
    }

    private fun lcs(a: List<Int>, b: List<Int>, aSize: Int, bSize: Int, d: MutableMap<Pair<Int, Int>, Int>): Int {
        return d.getOrPut(Pair(aSize, bSize)) {
            if (aSize <= 0 || bSize <= 0) {
                0
            } else if (a[aSize - 1] != b[bSize - 1]) {
                max(lcs(a, b, aSize - 1, bSize, d), lcs(a, b, aSize, bSize - 1, d))
            } else {
                lcs(a, b, aSize - 1, bSize - 1, d) + 1
            }
        }
    }
}