package capitulo3

typealias Identity<B> = (B) -> B

fun <A, B> foldLeftR(xs: List<A>, z: B, f: (B, A) -> B): B =
        foldRight(xs = xs,
                z = { b: B -> b },
                f = { a, g ->
                    { b ->
                        g(f(b, a))
                    }
                })(z)

fun <A, B> foldRightL(xs: List<A>, z: B, f: (A, B) -> B): B =
        foldLeft(
                xs,
                { b: B -> b },
                { g, a ->
                    { b ->
                        g(f(a, b))
                    }
                }
        )(z)