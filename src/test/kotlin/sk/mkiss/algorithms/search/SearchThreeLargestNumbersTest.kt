package sk.mkiss.algorithms.search

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SearchThreeLargestNumbersTest {

    @Test
    fun `should handle empty input`() {
        assertThat(SearchThreeLargestNumbers.find(emptyList())).isEmpty()
    }

    @Test
    fun `should handle input with 1 number`() {
        assertThat(SearchThreeLargestNumbers.find(listOf(1))).isEqualTo(listOf(1))
    }

    @Test
    fun `should handle input with 2 numbers`() {
        assertThat(SearchThreeLargestNumbers.find(listOf(1, 2))).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `should return top 3 numbers`() {
        assertThat(
            SearchThreeLargestNumbers.find(listOf(11, 2, 3, 10, 9, 8, 1, 9))
        ).isEqualTo(
            listOf(9, 10, 11)
        )
    }
}