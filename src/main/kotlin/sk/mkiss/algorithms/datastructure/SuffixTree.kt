package sk.mkiss.algorithms.datastructure

class SuffixTree(word: String) {

    private val root = Node()

    init {
        put(word)
    }

    private class Node {
        val children = mutableMapOf<Char, Node>()
    }

    companion object {
        private const val END_SYMBOL = '*'
    }

    fun contains(word: String): Boolean {
        var node = root
        for (letter in word) {
            if (node.children.containsKey(letter)) {
                node = node.children[letter]!!
            } else {
                return false
            }
        }
        return node.children.containsKey(END_SYMBOL)
    }

    fun put(word: String) {
        put(word, 0, root)
    }

    private fun put(word: String, idx: Int, parentNode: Node) {
        if (idx in word.indices) {
            val node = parentNode.children.getOrPut(word[idx]) { Node() }
            put(word, idx + 1, node)
        } else {
            parentNode.children[END_SYMBOL] = Node()
        }
    }
}