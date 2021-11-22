package sk.mkiss.algorithms.sort


object HeapSort : SortAlgorithm() {

    override fun <T : Comparable<T>> sort(array: Array<T>): Array<T> {

        initMaxHeap(array)

        for (i in array.size - 1 downTo 0) {
            array[i] = pop(array, i)
        }

        return array
    }

    private fun <T : Comparable<T>> initMaxHeap(array: Array<T>) {
        for (i in array.size - 1 downTo 0) {
            heapify(array, i, array.size)
        }
    }

    private fun <T : Comparable<T>> heapify(array: Array<T>, index: Int, heapSize: Int) {
        var i = index

        while (true) {
            val leftChildIndex = 2 * i + 1
            val rightChildIndex = leftChildIndex + 1

            i = listOf(leftChildIndex, rightChildIndex)
                .filter { it < heapSize }
                .filter { array[it] > array[i] }
                .maxByOrNull { array[it] }
                ?.also { swap(array, i, it) }
                ?: break
        }
    }

    private fun <T : Comparable<T>> pop(heap: Array<T>, lastIndexInHeap: Int): T {
        require(lastIndexInHeap >= 0)

        val topValue = heap[0]
        heap[0] = heap[lastIndexInHeap]

        heapify(heap, index = 0, heapSize = lastIndexInHeap)

        return topValue
    }

    private fun <T> swap(array: Array<T>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}