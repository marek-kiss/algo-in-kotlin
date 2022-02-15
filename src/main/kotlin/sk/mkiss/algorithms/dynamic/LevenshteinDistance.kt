package sk.mkiss.algorithms.dynamic

object LevenshteinDistance {

    fun distance(word1: String, word2: String): Int {
        val memory = List(word1.length + 1) {
            MutableList(word2.length + 1) { -1 }
        }

        return distance(word1, word2, word1.length, word2.length, memory)
    }

    private fun distance(
        word1: String,
        word2: String,
        e1: Int,
        e2: Int,
        memory: List<MutableList<Int>>
    ): Int {
        if (memory[e1][e2] == -1) {
            memory[e1][e2] = when {
                e1 == 0 -> e2
                e2 == 0 -> e1
                word1[e1 - 1] == word2[e2 - 1] ->
                    distance(word1, word2, e1 - 1, e2 - 1, memory)
                else -> listOf(
                    distance(word1, word2, e1 - 1, e2, memory),
                    distance(word1, word2, e1, e2 - 1, memory),
                    distance(word1, word2, e1 - 1, e2 - 1, memory)
                ).minOrNull()!! + 1
            }
        }
        return memory[e1][e2]
    }
}