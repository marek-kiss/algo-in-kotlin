package sk.mkiss.algorithms.datastructure

import java.util.*

class MinMaxStack<T : Comparable<T>> {

    private val stack: Deque<T> = LinkedList()
    private val minMaxStack: Deque<Pair<T, T>> = LinkedList()

    fun isEmpty(): Boolean = stack.isEmpty()

    fun push(value: T) {
        val newMinMax = minMaxStack.peek()?.let { (prevMin, prevMax) ->
            Pair(
                if (prevMin < value) prevMin else value,
                if (prevMax > value) prevMax else value
            )
        } ?: Pair(value, value)
        minMaxStack.push(newMinMax)
        stack.push(value)
    }

    fun pop(): T? {
        minMaxStack.pop()
        return stack.pop()
    }

    fun getMin(): T? {
        return minMaxStack.peek()?.first
    }

    fun getMax(): T? {
        return minMaxStack.peek()?.second
    }
}