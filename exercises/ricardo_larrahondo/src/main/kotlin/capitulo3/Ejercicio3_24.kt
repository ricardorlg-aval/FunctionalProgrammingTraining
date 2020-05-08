package capitulo3


fun <A> size(tree: Tree<A>): Int =
        when (tree) {
            is Leaf -> 1
            is Branch -> 1 + size(tree.left) + size(tree.right)
        }




