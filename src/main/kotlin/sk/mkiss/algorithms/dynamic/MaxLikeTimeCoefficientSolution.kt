package sk.mkiss.algorithms.dynamic

object MaxLikeTimeCoefficientSolution {

    fun maxSatisfaction(satisfaction: IntArray): Int {
        if (satisfaction.isEmpty()) return 0

        val sortedSatisfactions = satisfaction.sorted()
        var maxSatisfaction = sortedSatisfactions.last()
        var sumOfTopN = sortedSatisfactions.last()

        (sortedSatisfactions.size - 2 downTo 0).forEach { i ->
            if (maxSatisfaction < maxSatisfaction + sortedSatisfactions[i] + sumOfTopN) {
                maxSatisfaction += sortedSatisfactions[i] + sumOfTopN
                sumOfTopN += sortedSatisfactions[i]
            }
        }

        return if (maxSatisfaction > 0) maxSatisfaction else 0
    }
}