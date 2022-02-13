package sk.mkiss.algorithms.graph

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BSTTest {

    @Test
    fun `should insert values to bst`() {
        val bst = BST(10)

        bst.insert(5)
        bst.insert(15)
        bst.insert(11)
        bst.insert(17)
        bst.insert(16)
        bst.insert(1)

        val expected = buildBST()
        assertThat(bst).isEqualTo(expected)
    }

    @Test
    fun `contains - should return true if bst contains value`() {
        val bst = buildBST()
        assertThat(bst.contains(10)).isTrue
        assertThat(bst.contains(5)).isTrue
        assertThat(bst.contains(1)).isTrue
    }

    @Test
    fun `contains - should return false if value not included`() {
        val bst = buildBST()
        assertThat(bst.contains(2)).isFalse
        assertThat(bst.contains(14)).isFalse
        assertThat(bst.contains(100)).isFalse
    }

    @Test
    fun `remove - should not affect bst if the value is not included`() {
        val bst = buildBST()
        bst.remove(100)
        assertThat(bst).isEqualTo(buildBST())
    }

    @ParameterizedTest(name = "after removal of {0} the bst should be {1}")
    @MethodSource("getTestData")
    fun `remove - should remove the value from bst`(value: Int, expected: BST) {
        val bstAfterRemoval = buildBST().apply { remove(value) }
        assertThat(bstAfterRemoval).isEqualTo(expected)
    }

    private fun buildBST(): BST {
        return BST(10).apply {
            left = BST(5).apply {
                left = BST(1)
            }
            right = BST(15).apply {
                left = BST(11)
                right = BST(17).apply {
                    left = BST(16)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun getTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    10,
                    BST(11).apply {
                        left = BST(5).apply {
                            left = BST(1)
                        }
                        right = BST(15).apply {
                            right = BST(17).apply {
                                left = BST(16)
                            }
                        }
                    }),
                Arguments.of(
                    1,
                    BST(10).apply {
                        left = BST(5)
                        right = BST(15).apply {
                            left = BST(11)
                            right = BST(17).apply {
                                left = BST(16)
                            }
                        }
                    }
                ),
                Arguments.of(
                    5,
                    BST(10).apply {
                        left = BST(1)
                        right = BST(15).apply {
                            left = BST(11)
                            right = BST(17).apply {
                                left = BST(16)
                            }
                        }
                    }
                ),
                Arguments.of(
                    17,
                    BST(10).apply {
                        left = BST(5).apply {
                            left = BST(1)
                        }
                        right = BST(15).apply {
                            left = BST(11)
                            right = BST(16)
                        }
                    }
                )
            )
        }
    }
}