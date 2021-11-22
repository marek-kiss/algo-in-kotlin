package sk.mkiss.algorithms.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HeapSortTest {

    @Test
    fun `should sort unsorted list of Ints`() {
        assertThat(HeapSort.sort(arrayOf(9, 8, 1, 5, 6, 12, 3, 2))).isEqualTo(
            arrayOf(1, 2, 3, 5, 6, 8, 9, 12)
        )
    }

    @Test
    fun `should sort unsorted list of String`() {
        assertThat(HeapSort.sort(arrayOf("ba", "ab", "bb", "ac", "0"))).isEqualTo(
            arrayOf("0", "ab", "ac", "ba", "bb")
        )
    }

    @Test
    fun `should handle empty array`() {
        assertThat(HeapSort.sort(emptyArray<Int>())).isEqualTo(
            emptyArray<Int>()
        )
    }
}