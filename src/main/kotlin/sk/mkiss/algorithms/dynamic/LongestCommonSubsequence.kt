package sk.mkiss.algorithms.dynamic

import kotlin.math.max

object LongestCommonSubsequence {

    fun getSizeOfLongestCommonSubsequence(a: List<Int>, b: List<Int>): Int {
        val lcsMemory = mutableMapOf<Pair<Int, Int>, Int>()
        lcs(a, b, a.size, b.size, lcsMemory)
        return lcsMemory[a.size, b.size]!!
    }

    fun getLongestCommonSubsequence(a: List<Int>, b: List<Int>): List<Int> {
        val lcsMemory = mutableMapOf<Pair<Int, Int>, Int>()
        lcs(a, b, a.size, b.size, lcsMemory)
        return backtrack(a, b, lcsMemory)
    }

    private fun lcs(a: List<Int>, b: List<Int>, aSize: Int, bSize: Int, memory: MutableMap<Pair<Int, Int>, Int>): Int {
        return memory.getOrPut(Pair(aSize, bSize)) {
            if (aSize <= 0 || bSize <= 0) {
                0
            } else if (a[aSize - 1] != b[bSize - 1]) {
                max(lcs(a, b, aSize - 1, bSize, memory), lcs(a, b, aSize, bSize - 1, memory))
            } else {
                lcs(a, b, aSize - 1, bSize - 1, memory) + 1
            }
        }
    }

    private fun backtrack(a: List<Int>, b: List<Int>, memory: Map<Pair<Int, Int>, Int>): List<Int> {
        val lcs = mutableListOf<Int>()

        var aI = a.size
        var bI = b.size

        while (aI > 0 && bI > 0) {
            when (memory[aI, bI]) {
                memory[aI, bI - 1] -> bI -= 1
                memory[aI - 1, bI] -> aI -= 1
                else -> {
                    aI -= 1
                    bI -= 1
                    if (a[aI] == b[bI]) lcs.add(a[aI])
                }
            }
        }

        return lcs.reversed()
    }

    private operator fun <T> Map<Pair<Int, Int>, T>.get(x: Int, y: Int): T? = get(Pair(x, y))
}