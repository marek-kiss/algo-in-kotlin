package sk.mkiss.algorithms.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SearchInSortedMatrixTest {

    private val sortedMatrix = listOf(
        listOf(2, 4, 6, 100),
        listOf(3, 5, 9, 102),
        listOf(4, 6, 10, 104),
        listOf(7, 8, 12, 106),
        listOf(8, 9, 16, 108),
        listOf(10, 12, 17, 111),
    )

    @Test
    fun `should handle empty matrix`() {
        assertThat(SearchInSortedMatrix.search(emptyList(), 1)).isNull()
    }

    @Test
    fun `should return null if the value is not found`() {
        assertThat(SearchInSortedMatrix.search(sortedMatrix, 1)).isNull()
    }

    @ParameterizedTest(name = "shoudl find the {0} on {1}")
    @MethodSource("getTestData")
    fun `should return the position of the value if found`(value: Int, expectedPosition: Pair<Int, Int>) {
        assertThat(SearchInSortedMatrix.search(sortedMatrix, value)).isEqualTo(expectedPosition)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(2, Pair(0, 0)),
                Arguments.of(3, Pair(1, 0)),
                Arguments.of(5, Pair(1, 1)),
                Arguments.of(100, Pair(0, 3)),
                Arguments.of(111, Pair(5, 3))
            )
        }
    }
}