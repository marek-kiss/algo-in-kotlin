package sk.mkiss.algorithms.sort

abstract class SortAlgorithm {

    abstract fun <T : Comparable<T>> sort(array: Array<T>): Array<T>
}