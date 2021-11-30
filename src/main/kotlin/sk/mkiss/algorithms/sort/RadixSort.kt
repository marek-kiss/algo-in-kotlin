package sk.mkiss.algorithms.sort

object RadixSort {

    fun sort(array: Array<Int>, base: Int = array.size): Array<Int> {
        require(base > 1 || array.size <= 1) { "base has to be > 1" }

        if (array.size <= 1) return array

        var indexes = array.mapIndexed { index, value -> IndexCounter(index, value) }
        var groups = indexes.groupBy { it.value % base }

        while (groups.size != 1 || groups.indexesForFirstGroup().any { it.value != 0 }) {
            indexes = groups.toSortedMap()
                .flatMap { (_, sortedIndexes) -> sortedIndexes }
                .map { (index, value) -> IndexCounter(index = index, value = value / base) }

            groups = indexes.groupBy { it.value % base }
        }

        return indexes.map { (index, _) -> array[index] }.toTypedArray()
    }

    private fun Map<Int, List<IndexCounter>>.indexesForFirstGroup(): List<IndexCounter> = entries.first().value

    data class IndexCounter(
        val index: Int,
        val value: Int
    )
}