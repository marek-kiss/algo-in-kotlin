package sk.mkiss.algorithms.graph

class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        var node = this

        while (true) {
            node = if (node.value > value)
                node.left ?: break
            else
                node.right ?: break
        }
        if (node.value > value)
            node.left = BST(value)
        else
            node.right = BST(value)
    }

    fun contains(value: Int): Boolean {
        var node = this

        while (true) {
            when {
                node.value == value -> return true
                node.value > value -> node = node.left ?: return false
                node.value < value -> node = node.right ?: return false
            }
        }
    }

    fun remove(value: Int) {
        var node = this
        var parent = this

        while (true) {
            if (node.value > value) {
                parent = node
                node = node.left ?: return
            } else if (node.value < value) {
                parent = node
                node = node.right ?: return
            } else break
        }

        if (node.right != null) {
            parent = node

            var n2 = node.right!!
            while (n2.left != null) {
                parent = n2
                n2 = n2.left!!
            }
            if (parent.left == n2)
                parent.left = n2.right
            else
                parent.right = n2.right

            node.value = n2.value
        } else if (node.left != null) {
            parent = node

            var n2 = node.left!!
            while (n2.right != null) {
                parent = n2
                n2 = n2.right!!
            }
            if (parent.right == n2)
                parent.right = n2.left
            else
                parent.left = n2.left

            node.value = n2.value
        } else {
            if (parent.left == node) {
                parent.left = null
            } else {
                parent.right = null
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BST

        if (value != other.value) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value
        result = 31 * result + (left?.hashCode() ?: 0)
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "BST(value=$value, left=$left, right=$right)"
    }
}