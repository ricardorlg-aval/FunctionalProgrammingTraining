package capitulo3


fun maximum(tree: Tree<Int>): Int =
        when (tree) {
            is Leaf -> tree.value
            is Branch -> maxOf(maximum(tree.left), maximum(tree.right))
        }




