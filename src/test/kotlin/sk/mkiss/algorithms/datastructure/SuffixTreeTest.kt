package sk.mkiss.algorithms.datastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SuffixTreeTest {

    private val suffixTree = SuffixTree("first")
    private val words = listOf("alphabet", "alibaba", "amazon", "")


    @Test
    fun `contains should return true for the initial word`() {
        assertThat(suffixTree.contains("first")).isTrue
    }

    @Test
    fun `contains should return true if the word was inserted`() {
        words.forEach { word -> suffixTree.put(word) }

        words.forEach { word -> assertThat(suffixTree.contains(word)).isTrue }
    }

    @Test
    fun `contains should return false if the word was not inserted`() {
        words.forEach { word -> assertThat(suffixTree.contains(word)).isFalse() }
    }
}