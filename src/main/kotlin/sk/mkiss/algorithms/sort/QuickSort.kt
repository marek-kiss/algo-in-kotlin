package sk.mkiss.algorithms.sort

object QuickSort : SortAlgorithm() {

    override fun <T : Comparable<T>> sort(array: Array<T>): Array<T> {
        quickSort(array, 0, array.size)
        return array
    }

    private fun <T : Comparable<T>> quickSort(array: Array<T>, startIndex: Int, endIndex: Int) {
        if (endIndex - startIndex <= 1) return

        val pivot = getPivot(array, startIndex, endIndex)
        val (pivotStartIndex, pivotEndIndex) = partition(array, startIndex, endIndex, pivot)

        quickSort(array, startIndex, pivotStartIndex)
        quickSort(array, pivotEndIndex, endIndex)
    }

    private fun <T : Comparable<T>> partition(
        array: Array<T>,
        startIndex: Int,
        endIndex: Int,
        pivot: T
    ): Pair<Int, Int> {
        var s = startIndex
        var p = startIndex
        var e = endIndex - 1

        while (p <= e) {
            when {
                array[p] == pivot -> p++
                array[p] < pivot -> swap(array, s++, p++)
                array[p] > pivot -> swap(array, p, e--)
            }
        }

        return Pair(s, p)
    }

    /**
     * Select the median value of first, middle and last element from the given subarray as a pivot.
     */
    private fun <T : Comparable<T>> getPivot(array: Array<T>, startIndex: Int, endIndex: Int): T {
        var s = startIndex
        var e = endIndex - 1
        var m = startIndex + (endIndex - startIndex) / 2

        if (array[s] > array[m]) swap(array, s, m)
        if (array[s] > array[e]) swap(array, s, e)
        if (array[m] > array[e]) swap(array, m, e)

        return array[m]
    }
}