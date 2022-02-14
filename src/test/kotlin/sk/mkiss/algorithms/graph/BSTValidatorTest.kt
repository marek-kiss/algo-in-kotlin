package sk.mkiss.algorithms.graph

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BSTValidatorTest {

    @Test
    fun `should return true for bst with one element`() {
        assertThat(BSTValidator.isValid(BST(9))).isTrue
    }

    @Test
    fun `should return true for valid bst`() {
        val validBST = BST(9).apply {
            left = BST(5).apply {
                left = BST(4)
                right = BST(6).apply {
                    right = BST(6).apply {
                        right = BST(7)
                    }
                }
            }
            right = BST(20).apply {
                left = BST(10)
            }
        }
        assertThat(BSTValidator.isValid(validBST)).isTrue
    }

    @Test
    fun `should return false for invalid bst`() {
        assertThat(
            BSTValidator.isValid(
                BST(9).apply { left = BST(10) }
            )
        ).isFalse()

        assertThat(
            BSTValidator.isValid(
                BST(9).apply { right = BST(8) }
            )
        ).isFalse()
    }
}