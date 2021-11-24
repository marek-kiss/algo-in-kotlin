package sk.mkiss.algorithms.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

abstract class AbstractSortTest(private val sortAlgorithm: SortAlgorithm) {

    @Test
    fun `should sort unsorted array of Ints`() {
        assertThat(sortAlgorithm.sort(arrayOf(9, 8, 1, 5, 6, 12, 3, 2))).isEqualTo(
            arrayOf(1, 2, 3, 5, 6, 8, 9, 12)
        )
    }

    @Test
    fun `should sort unsorted array of String`() {
        assertThat(sortAlgorithm.sort(arrayOf("ba", "ab", "bb", "ac", "0"))).isEqualTo(
            arrayOf("0", "ab", "ac", "ba", "bb")
        )
    }

    @Test
    fun `should sort unsorted array with duplicates`() {
        assertThat(sortAlgorithm.sort(arrayOf('Z', 'X', 'A', 'Y', 'A', 'Z', 'A'))).isEqualTo(
            arrayOf('A', 'A', 'A', 'X', 'Y', 'Z', 'Z')
        )
    }

    @Test
    fun `should handle empty array`() {
        assertThat(sortAlgorithm.sort(emptyArray<Int>())).isEqualTo(
            emptyArray<Int>()
        )
    }
}