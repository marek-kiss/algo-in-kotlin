package sk.mkiss.algorithms.sort

object CountingSort {

    /**
     * Sort an array by a selector in ascending order.
     * This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.
     *
     * @param T - the type of elements to be sorted
     * @param R - the type of element attribute to sort by. Must implement Comparable and obey the general contract for hashCode()
     * @param array - the array of elements to be sorted
     * @param selector - mapping elements to attributes by which they will be sorted
     * @return the sorted array
     */
    inline fun <T, R: Comparable<R>> sortBy(array: Array<T>, crossinline selector: (T) -> R): Array<T> {

        val keyOccurrences = array.groupingBy { selector(it) }.eachCount()
        val sortedKeys = keyOccurrences.keys.sorted()

        // calculate positions for elements in a sorted array
        val newPositionsForElements = keyOccurrences.toMutableMap()
        for (i in (1 until sortedKeys.size)) {
            val key = sortedKeys[i]
            val prevKey = sortedKeys[i - 1]
            newPositionsForElements[key] = newPositionsForElements[prevKey]!! + keyOccurrences[key]!!
        }

        // put elements to correct positions
        for (element in array.reversedArray()) {
            val key = selector(element)
            val index = newPositionsForElements[key]!! - 1
            newPositionsForElements[key] = index
            array[index] = element
        }

        return array
    }
}