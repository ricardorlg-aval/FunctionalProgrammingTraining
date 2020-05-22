package capitulo4

object Ejercicio4_1 {
    fun <A, B> Option<A>.map(f: (A) -> B): Option<B> = when (this) {
        is Some -> Some(f(this.get))
        is None -> None
    }

    fun <A, B> Option<A>.flatMap(f: (A) -> Option<B>): Option<B> = this.map(f).getOrElse { None }

    fun <A> Option<A>.getOrElse(default: () -> A): A = when (this) {
        is Some -> this.get
        is None -> default()
    }

    fun <A> Option<A>.orElse(ob: () -> Option<A>): Option<A> = this.map { Some(it) }.getOrElse { ob() }

    fun <A> Option<A>.filter(f: (A) -> Boolean): Option<A> =
            this.flatMap { if (f(it)) this else None }

    fun <A, B> Option<A>.flatMap_2(
            f: (A) -> Option<B>
    ): Option<B> = when (this) {
        is Some -> f(this.get)
        is None -> None
    }

    fun <A> Option<A>.orElse_2(
            ob: () -> Option<A>
    ): Option<A> = when (this) {
        is Some -> this
        is None -> ob()
    }

    fun <A> Option<A>.filter_2(
            f: (A) -> Boolean
    ): Option<A> = when (this) {
        is Some ->
            if (f(this.get)) this
            else None
        is None -> None
    }

}