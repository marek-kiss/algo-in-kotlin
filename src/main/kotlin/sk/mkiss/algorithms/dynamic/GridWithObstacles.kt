package sk.mkiss.algorithms.dynamic

/**
 * A grid with obstacles.
 *
 * @property matrix - 2D array of Booleans. A False value on [X,Y] represents an obstacle on the Xth row and Yth column.
 */
class GridWithObstacles(private val matrix: Array<BooleanArray>) {

    private val pathsFrom00: Array<MutableMap<Int, Int>> = Array(matrix.size) { mutableMapOf() }

    init {
        require(matrix.isNotEmpty())
        require(matrix[0].isNotEmpty())

        val columns = matrix[0].size
        require(matrix.all { it.size == columns }) { "The number of columns needs to be the same for each row." }

        pathsFrom00[0][0] = 1
        matrix.forEachIndexed { y, row ->
            row.forEachIndexed { x, pathFree -> if (!pathFree) pathsFrom00[y][x] = 0 }
        }
    }

    /**
     * Count number of paths with distance equal to Manhattan distance between the [0,0] and the [x,y]
     *
     * @param x - the X position of the destination point in the grid
     * @param y - the Y position of the destination point in the grid
     * @return number of paths
     */
    fun countPathsFromTopLeftTo(x: Int, y: Int): Int {
        require(x in matrix[0].indices)
        require(y in matrix.indices)

        return pathsFrom00[y].getOrPut(x) {
            var pathsToXY = 0
            if (y > 0) pathsToXY += countPathsFromTopLeftTo(x, y - 1)
            if (x > 0) pathsToXY += countPathsFromTopLeftTo(x - 1, y)

            pathsToXY
        }
    }
}