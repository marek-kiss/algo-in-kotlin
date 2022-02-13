package sk.mkiss.algorithms.graph

import kotlin.math.abs

object ClosestValueInBST {

    fun findClosestValueInBst(tree: BST, target: Int): Int {

        var closest = tree.value
        var node = tree

        while (true) {
            if (abs(node.value - target) < abs(closest - target)) {
                closest = node.value
            }

            when {
                node.value > target -> node = node.left ?: break
                node.value < target -> node = node.right ?: break
                else -> {
                    closest = node.value;
                    break;
                }
            }
        }
        return closest
    }
}