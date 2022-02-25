package sk.mkiss.algorithms.datastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MinHeapTest {
    private val minHeap = MinHeap(listOf(5, 6, -1, 2, 7, -2))

    @Test
    fun `should correctly init and empty min heap`() {
        val heap = MinHeap(listOf(5, 6, -1, 2, 7, -2))

        assertThat(heap.pop()).isEqualTo(-2)
        assertThat(heap.pop()).isEqualTo(-1)
        assertThat(heap.pop()).isEqualTo(2)
        assertThat(heap.pop()).isEqualTo(5)
        assertThat(heap.pop()).isEqualTo(6)
        assertThat(heap.pop()).isEqualTo(7)
        assertThat(heap.pop()).isNull()
    }

    @Test
    fun `should correctly push into and pop from min heap with duplicates`() {
        val heap = MinHeap(listOf(3, 2, 4, 2, -1))

        heap.push(-1)
        heap.push(5)

        assertThat(heap.pop()).isEqualTo(-1)
        assertThat(heap.pop()).isEqualTo(-1)
        assertThat(heap.pop()).isEqualTo(2)
        assertThat(heap.pop()).isEqualTo(2)
        assertThat(heap.pop()).isEqualTo(3)
        assertThat(heap.pop()).isEqualTo(4)
        assertThat(heap.pop()).isEqualTo(5)
        assertThat(heap.pop()).isNull()
    }

    @Test
    fun `push - should add a new min element to min heap`() {
        assertThat(minHeap.peek()).isEqualTo(-2)

        minHeap.push(-3)

        assertThat(minHeap.peek()).isEqualTo(-3)
    }

    @Test
    fun `push - should add a new non-min element to min heap`() {
        assertThat(minHeap.peek()).isEqualTo(-2)

        minHeap.push(1)

        assertThat(minHeap.peek()).isEqualTo(-2)
    }

    @Test
    fun `peek - should return null if the heap is empty`() {
        assertThat(MinHeap(emptyList<Int>()).peek()).isNull()
    }

    @Test
    fun `pop - should return null if the heap is empty`() {
        assertThat(MinHeap(emptyList<Int>()).pop()).isNull()
    }
}