package capitulo3


fun depth(tree: Tree<Int>): Int =
        when (tree) {
            is Leaf -> 0
            is Branch -> 1 + maxOf(depth(tree.left), depth(tree.right))
        }




