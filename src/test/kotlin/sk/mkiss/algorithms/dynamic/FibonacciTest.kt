package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal

internal class FibonacciTest {

    @Test
    fun `should throw error for negative number`() {
        assertThrows<IllegalArgumentException> { Fibonacci.getNumber(-1) }
    }

    @ParameterizedTest(name = "fibonacci({0}) should be {1}")
    @CsvSource(
        "0,  0",
        "1,  1",
        "2,  1",
        "3,  2",
        "4,  3",
        "10, 55",
        "20, 6765",
        "30, 832040",
        "100,354224848179261915075"
    )
    fun `should correctly calculate the fibonacci number`(i: Int, expected: BigDecimal) {
        assertThat(Fibonacci.getNumber(i)).isEqualTo(expected)
    }
}