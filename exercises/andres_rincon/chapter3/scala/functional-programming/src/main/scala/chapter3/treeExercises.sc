import chapter3._

// Exercise 3.25
// Write a function size that counts the number of nodes (leaves and branches) in a tree.
def size[A](t: Tree[A]): Int = t match {
  case Leaf(_) => 1
  case Branch(l, r) => 1 + size(l) + size(r)
}
val t = Branch(Branch(Leaf(4), Leaf(5)), Leaf(9))
size(t)

// Exercise 3.26
// Write a function maximum that returns the maximum element in a Tree[Int]. (Note:
// In Scala, you can use x.max(y) or x max y to compute the maximum of two integers x
// and y.)

def maximum(t: Tree[Int]): Int = t match {
  case Leaf(t) => t
  case Branch(l, r) => maximum(l).max(maximum(r))
}
maximum(t)

// Exercise 3.27
// Write a function depth that returns the maximum path length from the root of a tree
// to any leaf.
def depth[A](t: Tree[A]): Int = t match {
  case Leaf(_) => 0
  case Branch(l, r) => 1 + (depth(l) max depth(r))
  //case Branch(l, r) => (1+depth(l)).max(1+depth(r))
}

val t1 = Branch(Branch(Leaf(4), Leaf(5)), Branch(Branch(Leaf(6), Leaf(7)), Leaf(9)))
depth(t1)

// Exercise 3.28
// Write a function map, analogous to the method of the same name on List, that modifies
// each element in a tree with a given function.

def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
  case Leaf(l) => Leaf(f(l))
  case Branch(l, r) => Branch(map(l)(f), map(r)(f))
}
map(t1) (x => x+1)

// Exercise 3.29
// Generalize size, maximum, depth, and map, writing a new function fold that abstracts
// over their similarities. Reimplement them in terms of this more general function. Can
// you draw an analogy between this fold function and the left and right folds for List?

def fold[A,B](t: Tree[A])(f: A => B)(g: (B,B) => B): B = t match {
  case Leaf(a) => f(a)
  case Branch(l,r) => g(fold(l)(f)(g), fold(r)(f)(g))
}

def sizeViaFold[A](t: Tree[A]): Int = fold(t)(a => 1)(1 + _ + _)
sizeViaFold(t)

def maximumViaFold(t: Tree[Int]): Int = fold(t)(a => a)(_ max _)
maximumViaFold(t)

def depthViaFold[A](t: Tree[A]): Int = fold(t)(a => 0)((d1,d2) => 1 + (d1 max d2))
depthViaFold(t1)

def mapViaFold[A,B](t: Tree[A])(f: A => B): Tree[B] =
  fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_,_))
map(t1) (x => x+1)