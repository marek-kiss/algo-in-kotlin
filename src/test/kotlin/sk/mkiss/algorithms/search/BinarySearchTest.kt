package sk.mkiss.algorithms.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BinarySearchTest {

    @Test
    fun `should return index of element if included`() {
        assertThat(BinarySearch.findIndexOf(arrayOf("1", "10", "20", "50", "100", "a"), "20")).isEqualTo(2)
    }

    @Test
    fun `should return null if element not included in array`() {
        assertThat(BinarySearch.findIndexOf(arrayOf("1", "10", "20", "50", "100", "a"), "30")).isNull()
    }

    @Test
    fun `should return null if array is empty`() {
        assertThat(BinarySearch.findIndexOf(arrayOf(), "11")).isNull()
    }
}