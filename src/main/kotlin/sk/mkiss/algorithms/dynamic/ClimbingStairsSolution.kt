package sk.mkiss.algorithms.dynamic

object ClimbingStairsSolution {

    fun countDistinctWays(n: Int): Int {
        require(n in 0..45)
        return countDistinctWays(n, m = mutableMapOf(0 to 0, 1 to 1, 2 to 2))
    }

    private fun countDistinctWays(n: Int, m: MutableMap<Int, Int>): Int {
        return m.getOrPut(n) { countDistinctWays(n - 1, m) + countDistinctWays(n - 2, m) }
    }
}