package sk.mkiss.algorithms.datastructure

class MinHeap<T : Comparable<T>>(
    input: List<T>
) {

    private val list: MutableList<T>

    init {
        list = input.toMutableList()
        for (idx in 1 until list.size) {
            heapifyUp(fromIdx = idx)
        }
    }

    private fun heapifyUp(fromIdx: Int) {
        var idx = fromIdx
        var parentIdx = getParentIdx(idx)

        if (parentIdx in list.indices && list[parentIdx] > list[idx]) {
            val temp = list[parentIdx]
            list[parentIdx] = list[idx]
            list[idx] = temp

            heapifyUp(parentIdx)
        }
    }

    private fun heapifyDown(fromIdx: Int) {

        val switchWithIdx = listOf(getLeftChildIdx(fromIdx), getRightChildIdx(fromIdx))
            .filter { childIdx -> childIdx in list.indices && list[childIdx] < list[fromIdx] }
            .minByOrNull { list[it] }

        if (switchWithIdx != null) {
            val temp = list[switchWithIdx]
            list[switchWithIdx] = list[fromIdx]
            list[fromIdx] = temp

            heapifyDown(switchWithIdx)
        }
    }

    fun push(value: T) {
        list.add(value)
        heapifyUp(list.size - 1)
    }

    fun pop(): T? {
        if (list.isEmpty()) return null

        val top = list[0]
        val last = list.removeLast()

        if (list.isNotEmpty()) {
            list[0] = last
            heapifyDown(0)
        }

        return top
    }

    fun peek(): T? {
        return if (list.isEmpty()) null
        else list.first()
    }

    private fun getLeftChildIdx(nodeIdx: Int): Int = nodeIdx * 2 + 1

    private fun getRightChildIdx(nodeIdx: Int): Int = nodeIdx * 2 + 2

    private fun getParentIdx(nodeIdx: Int): Int = (nodeIdx - 1) / 2
}