package sk.mkiss.algorithms.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TrieSortTest {

    @Test
    fun `should sort unsorted array of Strings`() {
        assertThat(
            TrieSort.getSorted(arrayOf("xyzxyz", "xyz", "xxx", "abc", "aabc", "aaabc", "a", "xyz", "trie sort test"))
        ).isEqualTo(
            arrayOf("a", "aaabc", "aabc", "abc", "trie sort test", "xxx", "xyz", "xyz", "xyzxyz")
        )
    }

    @Test
    fun `should handle array with 1 element`() {
        assertThat(TrieSort.getSorted(arrayOf("1"))).isEqualTo(
            arrayOf("1")
        )
    }

    @Test
    fun `should handle empty array`() {
        assertThat(TrieSort.getSorted(emptyArray())).isEqualTo(
            emptyArray<String>()
        )
    }
}