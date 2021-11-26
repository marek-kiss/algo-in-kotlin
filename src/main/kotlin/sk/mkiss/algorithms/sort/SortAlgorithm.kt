package sk.mkiss.algorithms.sort

abstract class SortAlgorithm {

    abstract fun <T : Comparable<T>> sort(array: Array<T>): Array<T>

    protected fun <T> swap(array: Array<T>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}