package sk.mkiss.algorithms.search

object SearchThreeLargestNumbers {

    fun find(input: List<Int>): List<Int> {
        if(input.size < 3) return input

        val top3 = mutableListOf(input[0], input[1], input[2]).apply{ sort() }

        for(i in 3 until input.size) {
            if(input[i] > top3[0]) {
                top3[0] = input[i]
                top3.sort()
            }
        }

        return top3
    }
}