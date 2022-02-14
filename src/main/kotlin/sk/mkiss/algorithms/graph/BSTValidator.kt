package sk.mkiss.algorithms.graph

object BSTValidator {

    fun isValid(bst: BST): Boolean {
        var valid = true

        bst.left?.also { left ->
            valid = valid && isValid(left, Int.MIN_VALUE, bst.value)
        }

        bst.right?.also { right ->
            valid = valid && isValid(right, bst.value, Int.MAX_VALUE)
        }

        return valid

    }

    private fun isValid(node: BST, minVal: Int, maxVal: Int): Boolean {
        var valid = node.value in minVal until maxVal

        if(!valid) return false

        node.left?.also { left -> valid = valid && isValid(left, minVal, node.value) }
        node.right?.also { right -> valid = valid && isValid(right, node.value, maxVal) }

        return valid
    }
}