package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ClimbingStairsSolutionTest {

    @ParameterizedTest(name = "there should be {1} ways to climb {1} stairs")
    @CsvSource(
        "0,  0",
        "1,  1",
        "2,  2",
        "3,  3",
        "4,  5",
        "5,  8"
    )
    fun `should count number of ways to climb N stairs`(stairs: Int, expected: Int) {
        assertThat(ClimbingStairsSolution.countDistinctWays(stairs)).isEqualTo(expected)
    }
}