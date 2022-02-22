package sk.mkiss.algorithms.datastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MinMaxStackTest {

    val minMaxStack = MinMaxStack<Int>()

    @BeforeEach
    fun initStack() {
        minMaxStack.push(5)
        minMaxStack.push(4)
        minMaxStack.push(3)
        minMaxStack.push(8)
        minMaxStack.push(5)
    }

    @Test
    fun `getMin - should return correct min value`() {
        assertThat(minMaxStack.getMin()).isEqualTo(3)
    }

    @Test
    fun `getMin - should return correct min value after the previous min was popped out`() {
        repeat(3) { minMaxStack.pop() }

        assertThat(minMaxStack.getMin()).isEqualTo(4)
    }

    @Test
    fun `getMin - should return null if the stack is empty`() {
        repeat(5) { minMaxStack.pop() }

        assertThat(minMaxStack.getMin()).isNull()
    }

    @Test
    fun `getMax - should return correct max value`() {
        assertThat(minMaxStack.getMax()).isEqualTo(8)
    }

    @Test
    fun `getMax - should return correct max value after the previous max was popped out`() {
        repeat(2) { minMaxStack.pop() }

        assertThat(minMaxStack.getMax()).isEqualTo(5)
    }

    @Test
    fun `getMax - should return null if the stack is empty`() {
        repeat(5) { minMaxStack.pop() }

        assertThat(minMaxStack.getMax()).isNull()
    }

    @Test
    fun `pop - should return and remove the top element`() {
        assertThat(minMaxStack.pop()).isEqualTo(5)
        assertThat(minMaxStack.pop()).isEqualTo(8)
        assertThat(minMaxStack.pop()).isEqualTo(3)
        assertThat(minMaxStack.pop()).isEqualTo(4)
        assertThat(minMaxStack.pop()).isEqualTo(5)
    }

    @Test
    fun `pop - should return null if the stack is empty`() {
        repeat(5) { minMaxStack.pop() }

        assertThat(minMaxStack.getMin()).isNull()
    }

    @Test
    fun `push - should correctly update the stack`() {
        minMaxStack.push(10)
        minMaxStack.push(-2)

        assertThat(minMaxStack.getMax()).isEqualTo(10)
        assertThat(minMaxStack.getMin()).isEqualTo(-2)
    }

    @Test
    fun `isEmpty - should return false if the stack is not empty`() {
        assertThat(minMaxStack.isEmpty()).isFalse
    }

    @Test
    fun `isEmpty - should return true if the stack is empty`() {
        assertThat(MinMaxStack<Int>().isEmpty()).isTrue
    }
}