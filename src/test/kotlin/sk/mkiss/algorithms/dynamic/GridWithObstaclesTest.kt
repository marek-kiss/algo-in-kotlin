package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GridWithObstaclesTest {
    private val grid3x3 = GridWithObstacles(
        arrayOf(
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, true),
            booleanArrayOf(true, true, true)
        )
    )

    @Test
    fun `should throw an error if the matrix is empty`() {
        assertThrows<IllegalArgumentException> { GridWithObstacles(emptyArray()) }
    }

    @Test
    fun `should throw an error if the matrix has 0 columns`() {
        assertThrows<IllegalArgumentException> { GridWithObstacles(arrayOf(booleanArrayOf())) }
    }

    @Test
    fun `should throw an error if the matrix is invalid`() {
        assertThrows<IllegalArgumentException> {
            GridWithObstacles(
                arrayOf(
                    booleanArrayOf(true),
                    booleanArrayOf(true, true),
                    booleanArrayOf(true)
                )
            )
        }
    }

    @Test
    fun `should throw an error if the destination point is out of matrics`() {
        assertThrows<IllegalArgumentException> { grid3x3.countPathsFromTopLeftTo(-1, 1) }
        assertThrows<IllegalArgumentException> { grid3x3.countPathsFromTopLeftTo(1, -1) }
        assertThrows<IllegalArgumentException> { grid3x3.countPathsFromTopLeftTo(3, 1) }
        assertThrows<IllegalArgumentException> { grid3x3.countPathsFromTopLeftTo(1, 3) }
    }

    @Test
    fun `should return 1 path for the point (0,0)`() {
        assertThat(grid3x3.countPathsFromTopLeftTo(x = 0, y = 0)).isEqualTo(1)
    }

    @Test
    fun `should count paths in a grid without obstacles`() {
        assertThat(grid3x3.countPathsFromTopLeftTo(x = 2, y = 2)).isEqualTo(6)
    }

    @Test
    fun `should return 0 if all paths are blocked`() {
        val gridWithObstacles3x3 = GridWithObstacles(
            arrayOf(
                booleanArrayOf(true, false, true),
                booleanArrayOf(true, false, true),
                booleanArrayOf(true, false, true)
            )
        )
        assertThat(gridWithObstacles3x3.countPathsFromTopLeftTo(x = 2, y = 2)).isEqualTo(0)
    }

    @Test
    fun `should count paths in a grid with obstacles`() {
        val gridWithObstacle3x3 = GridWithObstacles(
            arrayOf(
                booleanArrayOf(true, true, true),
                booleanArrayOf(true, false, true),
                booleanArrayOf(true, true, true)
            )
        )
        assertThat(gridWithObstacle3x3.countPathsFromTopLeftTo(x = 2, y = 2)).isEqualTo(2)
    }

    @Test
    fun `should count paths in a big grid with obstacles`() {
        val gridWithObstacles9x9 = GridWithObstacles(
            arrayOf(
                booleanArrayOf(true, true, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, false, true, true, true, true, true),
                booleanArrayOf(true, false, true, true, true, true, true, true, true),
                booleanArrayOf(true, false, true, true, true, true, true, true, true)
            )
        )
        assertThat(gridWithObstacles9x9.countPathsFromTopLeftTo(x = 8, y = 8)).isEqualTo(7)
    }
}