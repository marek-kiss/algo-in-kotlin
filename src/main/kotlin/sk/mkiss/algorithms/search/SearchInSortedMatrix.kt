package sk.mkiss.algorithms.search

object SearchInSortedMatrix {

    fun search(sortedMatrix: List<List<Int>>, target: Int): Pair<Int, Int>? {
        if (sortedMatrix.isEmpty() || sortedMatrix[0].isEmpty()) return null
        var i = 0
        var j = sortedMatrix[0].size - 1

        while (i in sortedMatrix.indices && j in sortedMatrix[0].indices) {
            if (sortedMatrix[i][j] == target) return Pair(i, j)
            else if (sortedMatrix[i][j] > target) j--
            else i++
        }
        return null
    }
}