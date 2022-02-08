package sk.mkiss.algorithms.dynamic

object CountingBits {

    fun countBits(n: Int): IntArray {
        require(n > 0)

        val ans = IntArray(n + 1) { -1 }
        ans[0] = 0

        (0..n).forEach { i ->
            if (ans[i] == -1) {
                ans[i] = ans[i / 2] + i % 2
            }
        }

        return ans
    }
}