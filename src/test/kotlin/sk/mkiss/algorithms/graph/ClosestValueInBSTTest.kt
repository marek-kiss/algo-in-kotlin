package sk.mkiss.algorithms.graph

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ClosestValueInBSTTest {

    private val bst = BST(10).apply {
        left = BST(4).apply { left = BST(3).apply { left = BST(2) } }
        right = BST(15).apply {
            left = BST(11)
            right = BST(17).apply {
                left = BST(16)
                right = BST(18)
            }
        }
    }

    @ParameterizedTest(name = "the closest value to {0} in BST should be {1}")
    @MethodSource("getTestData")
    fun `should find the closest value in BST`(target: Int, expected: Int) {
        assertThat(ClosestValueInBST.findClosestValueInBst(bst, target)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(19, 18),
                Arguments.of(1_000, 18),
                Arguments.of(14, 15),
                Arguments.of(12, 11),
                Arguments.of(1, 2),
                Arguments.of(-1_000, 2),
                Arguments.of(6, 4),
                Arguments.of(8, 10),
                Arguments.of(2, 2),
                Arguments.of(10, 10),
            )
        }
    }
}