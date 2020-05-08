package capitulo3

fun <A, B> map(tree: Tree<A>, f: (A) -> B): Tree<B> =
        when (tree) {
            is Leaf -> Leaf(f(tree.value))
            is Branch -> Branch(
                    map(tree.left, f),
                    map(tree.right, f)
            )
        }





