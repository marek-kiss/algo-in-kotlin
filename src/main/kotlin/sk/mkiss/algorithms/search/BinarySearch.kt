package sk.mkiss.algorithms.search

object BinarySearch {

    fun <T : Comparable<T>> findIndexOf(array: Array<T>, element: T): Int? {
        return binarySearch(array, element, 0, array.size)
    }

    private fun <T : Comparable<T>> binarySearch(array: Array<T>, element: T, startIndex: Int, endIndex: Int): Int? {
        val size = endIndex - startIndex
        if (size == 0) return null
        if (size == 1) return if (array[startIndex] == element) startIndex else null

        val middle = startIndex + size / 2

        return if (array[middle] > element)
            binarySearch(array, element, startIndex = startIndex, endIndex = middle)
        else
            binarySearch(array, element, startIndex = middle, endIndex = endIndex)
    }
}
