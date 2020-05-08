package capitulo3

import kotlin.math.max

fun <A, B> fold(ta: Tree<A>, l: (A) -> B, b: (B, B) -> B): B =
        when (ta) {
            is Leaf -> l(ta.value)
            is Branch -> b(fold(ta.left, l, b), fold(ta.right, l, b))
        }

fun <A> sizeF(ta: Tree<A>): Int = fold(ta, { 1 }, { b1, b2 -> 1 + b1 + b2 })

fun maximumF(ta: Tree<Int>): Int = fold(ta, { a -> a }, { b1, b2 -> maxOf(b1, b2) })

fun <A> depthF(ta: Tree<A>): Int = fold(ta, { 0 }, { b1, b2 -> 1 + max(b1, b2) })

fun <A, B> mapF(ta: Tree<A>, f: (A) -> B): Tree<B> = fold(ta, { a -> Leaf(f(a)) }, { b1: Tree<B>, b2: Tree<B> -> Branch(b1, b2) })


