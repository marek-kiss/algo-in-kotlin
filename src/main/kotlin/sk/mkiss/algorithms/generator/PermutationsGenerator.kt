package sk.mkiss.algorithms.generator

import sk.mkiss.algorithms.sort.QuickSort

object PermutationsGenerator {

    /**
     * Generate all permutations of elements in the given set
     *
     * @param T - the type of elements in the input set
     * @param input - the input set
     * @return list containing all permutations
     */
    fun <T> generateAll(input: Set<T>): List<List<T>> {
        if (input.isEmpty()) return emptyList()

        val inputAsList = input.toList()
        val permutations = mutableListOf<List<T>>()
        var indexPermutation: Array<Int>? = Array(input.size) { i -> i }

        do {
            permutations.add(indexPermutation!!.map { inputAsList[it] })
            indexPermutation = nextGreaterOrNull(indexPermutation)
        } while (indexPermutation != null)

        return permutations
    }

    private fun nextGreaterOrNull(number: Array<Int>): Array<Int>? {
        if (number.size <= 1) return null

        var i = number.size - 2
        while (i >= 1 && number[i] >= number[i + 1]) {
            i--
        }
        if (number[i] >= number[i + 1]) return null

        var indexOfSmallestGreater = i + 1
        for (j in i + 1 until number.size) {
            if (number[j] > number[i] && number[j] < number[indexOfSmallestGreater]) {
                indexOfSmallestGreater = j
            }
        }

        swap(number, i, indexOfSmallestGreater)
        val sorted = QuickSort.sort(number.sliceArray(i + 1 until number.size))

        return number.sliceArray(0..i) + sorted
    }

    private fun <T> swap(array: Array<T>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}