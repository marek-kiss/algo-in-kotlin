package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CountingBitsTest {

    @Test
    fun `should throw error for negative input`() {
        assertThrows<IllegalArgumentException> { CountingBits.countBits(-1) }
    }

    @Test
    fun `should correctly count bits for the first 8 numbers`() {
        assertThat(CountingBits.countBits(7)).isEqualTo(intArrayOf(0, 1, 1, 2, 1, 2, 2, 3))
    }
}