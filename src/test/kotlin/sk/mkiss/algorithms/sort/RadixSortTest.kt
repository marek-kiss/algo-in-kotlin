package sk.mkiss.algorithms.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RadixSortTest {

    private val unsorted = arrayOf(9_001, 8_005, 10, 9_005, 8_001, 12, 3, 2, 20_001)

    private val sorted = arrayOf(2, 3, 10, 12, 8_001, 8_005, 9_001, 9_005, 20_001)

    @Test
    fun `should sort unsorted array`() {
        assertThat(RadixSort.sort(unsorted)).isEqualTo(sorted)
    }

    @Test
    fun `should sort unsorted array with base 2`() {
        assertThat(RadixSort.sort(unsorted, base = 2)).isEqualTo(sorted)
    }

    @Test
    fun `should sort unsorted array with base 10`() {
        assertThat(RadixSort.sort(unsorted, base = 10)).isEqualTo(sorted)
    }

    @Test
    fun `should handle array with 1 element`() {
        assertThat(RadixSort.sort(arrayOf(10))).isEqualTo(
            arrayOf(10)
        )
    }

    @Test
    fun `should handle empty array`() {
        assertThat(RadixSort.sort(emptyArray())).isEqualTo(
            emptyArray<Int>()
        )
    }

}