package sk.mkiss.algorithms.sort

object MergeSort : SortAlgorithm() {

    override fun <T : Comparable<T>> sort(array: Array<T>): Array<T> {
        return mergeSort(array, 0, array.size)
    }

    private fun <T : Comparable<T>> mergeSort(array: Array<T>, startIndex: Int, endIndex: Int): Array<T> {
        val size = endIndex - startIndex
        if (size <= 1) return array

        val middleIndex = startIndex + size / 2
        mergeSort(array, startIndex, middleIndex)
        mergeSort(array, middleIndex, endIndex)

        return merge(array, startIndex, middleIndex, endIndex)
    }

    private fun <T : Comparable<T>> merge(array: Array<T>, startIndex: Int, middleIndex: Int, endIndex: Int): Array<T> {
        val tempArray = array.copyOfRange(startIndex, middleIndex)
        val tempArrayEndIndex = middleIndex-startIndex

        var i = 0
        var j = middleIndex
        var k = startIndex

        while (i < tempArrayEndIndex && j < endIndex) {
            if (tempArray[i] < array[j]) {
                array[k] = tempArray[i++]
            } else {
                array[k] = array[j++]
            }
            k++
        }

        while (i < tempArrayEndIndex) {
            array[k++] = tempArray[i++]
        }

        while (j < endIndex) {
            array[k++] = array[j++]
        }

        return array
    }
}