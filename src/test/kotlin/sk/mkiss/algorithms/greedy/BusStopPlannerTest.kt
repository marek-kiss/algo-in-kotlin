package sk.mkiss.algorithms.greedy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BusStopPlannerTest {

    val busStopPlanner = BusStopPlanner(maxDistanceToBusStop = 500)

    @Test
    fun `should handle empty list of houses`() {
        assertThat(busStopPlanner.planStops(emptyList())).isEmpty()
    }

    @Test
    fun `should throw error if houses are not in ascending order`() {
        assertThrows<IllegalArgumentException> { busStopPlanner.planStops(listOf(600, 650, 610)) }
    }

    @Test
    fun `should plan the lowest required number of bus stops`() {
        assertThat(busStopPlanner.planStops(listOf(600, 1600))).hasSize(1)
        assertThat(busStopPlanner.planStops(listOf(600, 1601))).hasSize(2)
        assertThat(busStopPlanner.planStops(listOf(600, 1601, 2602))).hasSize(3)
        assertThat(busStopPlanner.planStops(listOf(1, 30_000_000))).hasSize(2)
    }
}