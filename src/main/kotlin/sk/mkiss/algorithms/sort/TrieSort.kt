package sk.mkiss.algorithms.sort

import java.util.*

object TrieSort {

    fun getSorted(array: Array<String>): Array<String> {
        if (array.size <= 1) return array

        val trie = Trie()

        for(word in array) {
            trie.add(word)
        }

        return trie.getSortedWords().toTypedArray()
    }

    class Trie {
        private val root = Node()

        data class Node(
            val childNodes: SortedMap<Char, Node> = sortedMapOf(),
            var countWordEnds: Int = 0
        )

        fun add(word: String) {
            var node = root
            for (letter in word) {
                node = node.childNodes.getOrPut(letter) { Node() }
            }
            node.countWordEnds += 1
        }

        fun getSortedWords(): List<String> {
            val words = mutableListOf<String>()
            addWords(root, words, wordBuilder = "")
            return words
        }

        private fun addWords(node: Node, wordCollector: MutableList<String>, wordBuilder: String) {
            repeat(node.countWordEnds) { wordCollector.add(wordBuilder) }
            node.childNodes.forEach { (letter, child) ->
                addWords(child, wordCollector, wordBuilder = wordBuilder + letter)
            }
        }
    }
}