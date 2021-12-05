package sk.mkiss.algorithms.generator

import kotlin.math.pow

object SubsetsGenerator {

    /**
     * Generate all subsets for the given set
     *
     * @param T - the type of elements in the input set
     * @param input - the input set
     * @return list containing all subsets
     */
    fun <T> generateAll(input: Set<T>): List<Set<T>> {
        val n = input.size
        val inputAsList = input.toList()

        return (0 until 2.pow(n)).map { x ->
            (0 until n).filter { n -> testNthBit(x, n) }.map { i -> inputAsList[i] }.toSet()
        }
    }

    private fun testNthBit(x: Int, i: Int): Boolean = (x and (1 shl i)) != 0

    private fun Int.pow(exponent: Int) = this.toDouble().pow(exponent).toInt()
}