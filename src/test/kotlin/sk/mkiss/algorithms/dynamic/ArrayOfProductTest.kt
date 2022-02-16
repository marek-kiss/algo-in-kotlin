package sk.mkiss.algorithms.dynamic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArrayOfProductTest {

    @Test
    fun `should handle empty array`() {
        assertThat(ArrayOfProduct.productExceptSelf(intArrayOf())).isEqualTo(intArrayOf())
    }

    @Test
    fun `should return products of all numbers except self`() {
        assertThat(ArrayOfProduct.productExceptSelf(intArrayOf(10, 2, 3, 5))).isEqualTo(intArrayOf(30, 150, 100, 60))
    }
}