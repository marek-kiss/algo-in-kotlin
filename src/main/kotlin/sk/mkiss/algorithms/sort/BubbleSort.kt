package sk.mkiss.algorithms.sort

object BubbleSort : SortAlgorithm() {

    override fun <T : Comparable<T>> sort(array: Array<T>): Array<T> {
        if (array.size <= 1) return array

        var isUnsorted = true

        while (isUnsorted) {
            isUnsorted = false
            for (i in (0 until array.size - 1)) {
                if (array[i] > array[i + 1]) {
                    isUnsorted = true
                    swap(array, i, i + 1)
                }
            }
        }

        return array
    }
}