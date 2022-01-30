package sk.mkiss.algorithms.greedy

class BusStopPlanner(val maxDistanceToBusStop: Int) {

    /**
     * Plan positions for a minimal number of bus stops required to serve the given list of houses.
     * Each house needs to be in a defined radius {@link #maxDistanceToBus} from a nearby bus stop.
     *
     * @param houses - sorted list of Integers representing positions of houses
     * @return list of positions for bus stops
     */
    fun planStops(houses: List<Int>): List<Int> {
        require(houses.isSorted())

        if (houses.isEmpty()) return emptyList()

        val busStopPositions = mutableListOf(houses.first() + maxDistanceToBusStop)
        houses.forEach { housePosition ->
            if (busStopPositions.last() + maxDistanceToBusStop < housePosition)
                busStopPositions.add(housePosition + maxDistanceToBusStop)
        }

        return busStopPositions
    }

    private fun <T : Comparable<T>> List<T>.isSorted(): Boolean {
        if (size < 2) return true

        var prev = first()
        (1 until size).forEach { i ->
            if (prev > get(i)) {
                return false
            } else {
                prev = get(i)
            }
        }
        return true
    }
}

