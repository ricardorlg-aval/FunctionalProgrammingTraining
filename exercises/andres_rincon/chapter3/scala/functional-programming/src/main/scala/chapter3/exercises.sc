import chapter3._

import scala.annotation.tailrec

// Exercise 3.1
val x = List(1, 2, 3, 4, 5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x
  case Nil => 42
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
  case Cons(h, t) => h + List.sum(t)
  case _ => 101
}
println("the answer should be 3", x)

// Exercise 3.2

val xs = List(1, 2, 3)
val t = List.tail(xs)
// Exercise 3.3.
def setHead[A](xs: List[A], value: A): List[A] = xs match {
  case Nil => Cons(value, Nil)
  case Cons(_, t) => Cons(value, t)
}
val r = setHead(xs, 5)

// Exercise 3.4
def drop[A](l: List[A], n: Int): List[A] = n match {
  case 0 => l
  case _ => drop(List.tail(l), n - 1)
}
val d = drop(xs, 2)

// exercise 3.5
//Implement dropWhile, which removes elements from the List prefix as long as they
//match a predicate.

def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  case Cons(h, t) if f(h) => dropWhile(t, f)
  case _ => l
}

val i = List(2, 4, 6, 8, 9)
val s = dropWhile(i, (x: Int) => x % 2 == 0)


// append
def append[A](a1: List[A], a2: List[A]): List[A] =
  a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
  }
val xs1 = List(1, 2, 3, 4, 5)
val c1 = List(6, 7, 8, 9, 0)
val r1 = append(xs1, c1)

// exercise 3.6
// Not everything works out so nicely. Implement a function, init, that returns a List
//   consisting of all but the last element of a List. So, given List(1,2,3,4), init will
// return List(1,2,3). Why can’t this function be implemented in constant time like
//  tail?
def init[A](l: List[A]): List[A] = l match {
  case Nil => Nil
  case Cons(h, Nil) => Nil
  case Cons(h, t) => Cons(h, init(t))
}

val r2 = init(List(1, 2, 3, 4, 5))

// exercise 3.2. fold right
val f1 = List(1, 2, 3)
val f2 = List.foldRight(f1, 0)((x, y) => x + y)

// Regular recursion
// foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)((x,y) => x + y)
// 1 + foldRight(Cons(2, Cons(3, Nil)), 0)((x,y) => x + y)
// 1 + (2 + foldRight(Cons(3, Nil), 0)((x,y) => x + y))
// 1 + (2 + (3 + (foldRight(Nil, 0)((x,y) => x + y))))
// 1 + (2 + (3 + (0)))

// exercise 3.7
// Can product, implemented using foldRight, immediately halt the recursion and
// return 0.0 if it encounters a 0.0? Why or why not? Consider how any short-circuiting
// might work if you call foldRight with a large list. This is a deeper question that we’ll
// return to in chapter 5.
val f3 = List(1.0, 2.0, 3.0, 0.0)
val f4 = List.foldRight(f1, 1.0)((x, y) => x * y)

//exercise 3.8.
// See what happens when you pass Nil and Cons themselves to foldRight, like this:
// foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)).10 What do you think this
// says about the relationship between foldRight and the data constructors of List?
val f5 = List(1, 2, 3, 4, 5, 6)
// it will copy the list
val f6 = List.foldRight(f5, Nil: List[Int])((x, y) => Cons(x, y))

// Exercise 3.9
// Compute the length of a list using foldRight.
// def length[A](as: List[A]): Int
def length[A](as: List[A]): Int = as match {
  case Nil => 0
  case Cons(h, t) => List.foldRight(as, 0)((_, y) => y + 1)
}
length(f5)

// Exercise 3.10
// Our implementation of foldRight is not tail-recursive and will result in a StackOverflowError
// for large lists (we say it’s not stack-safe). Convince yourself that this is the
// case, and then write another general list-recursion function, foldLeft, that is
// tail-recursive, using the techniques we discussed in the previous chapter. Here is its
// signature:11
@tailrec
def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  case Nil => z
  case Cons(h, t) => foldLeft(t, f(z, h))(f)
}

// Exercise 3.11
// Write sum, product, and a function to compute the length of a list using foldLeft.
val l = List(1, 2, 3)
val l1 = foldLeft(f1, 0)((x, y) => x + y)
val q = foldLeft(f1, Nil: List[Int])((x , y) => Cons(y, x))
// foldLeft(List[1,2,3], Nil)(Cons(b,a))
//   foldleft(List[2,3], Cons(1, Nil))(Cons(b,a))
//    foldleft(List[3], Cons(2, Cons( 1,Nil)))(Cons(b,a))
//    foldleft(Nil, Cons(3, Cons(2, Cons(Nil, 1))))(Cons(b,a))


// Exercise 3.12.
// Write a function that returns the reverse of a list (given List(1,2,3) it returns
//   List(3,2,1)). See if you can write it using a fold.

def reverse[A](as: List[A]): List[A] = as match {
  case Nil => Nil
  case Cons(h, t) => foldLeft(as, Nil: List[A])((z, x) => Cons(x, z))
}

val l2 = reverse(l)

// Exercise 3.13
// Hard: Can you write foldLeft in terms of foldRight? How about the other way
// around? Implementing foldRight via foldLeft is useful because it lets us implement
// foldRight tail-recursively, which means it works even for large lists without overflowing
// the stack.

def foldLeftUsingFoldRight[A, B](as: List[A], z: B)(f: (B, A) => B) =
  List.foldRight(reverse(as), z)((a, b) => f(b, a))
def foldRightViaFoldLeft[A, B](l: List[A], z: B)(f: (A, B) => B): B =
  foldLeft(reverse(l), z)((b, a) => f(a, b))

val l3 = foldLeftUsingFoldRight(l, Nil: List[Int])((a, b) => Cons(b, a))
val l4 = foldRightViaFoldLeft(l, Nil: List[Int])((a, b) => Cons(a, b))


// Exercise 3.14.
// Implement append in terms of either foldLeft or foldRight.
// append add a list to the end of the list.
def appendWithFoldRight[A](as: List[A], bs: List[A]): List[A] = List.foldRight(as, bs)(Cons(_, _))
val l5 = appendWithFoldRight(List(1, 2, 3), List(4, 5))

def appendWithFoldLeft[A](as: List[A], bs: List[A]): List[A] = foldLeft(reverse(as), bs)((a, b) => Cons(b, a))
val l6 = appendWithFoldLeft(List(1, 2, 3), List(4, 5))

// Exercise 3.15
// Hard: Write a function that concatenates a list of lists into a single list. Its runtime
// should be linear in the total length of all lists. Try to use functions we have already
// defined.

def concat[A](as: List[List[A]]): List[A] = as match {
  case Nil => Nil
  case Cons(h, t) => appendWithFoldRight(h, concat(t))
}

val q1 = concat(List(List(1, 2, 3), List(4, 5, 6)))

// Exercise 3.16
// Write a function that transforms a list of integers by adding 1 to each element.
// (Reminder: this should be a pure function that returns a new List!)

def add(as: List[Int]): List[Int] =
  List.foldRight(as, Nil: List[Int])((h, t) => Cons(h + 1, t))

val q2 = add(List(1, 2, 3))

// Exercise 3.17
// Write a function that turns each value in a List[Double] into a String. You can use
// the expression d.toString to convert some d: Double to a String.

def toString(as: List[Double]): List[String] =
  List.foldRight(as, Nil: List[String])((h, t) => Cons(h.toString, t))

toString(List(1.0, 2.0, 3.0))

// Exercise 3.18
// Write a function map that generalizes modifying each element in a list while maintaining
// the structure of the list. Here is its signature:12

def map[A, B](as: List[A])(f: A => B): List[B] =
  List.foldRight(as, Nil: List[B])((h, t) => Cons(f(h), t))

map(List(1, 2, 3))(x => x + 1)

// Exercise 3.19
// Write a function filter that removes elements from a list unless they satisfy a given
// predicate. Use it to remove all odd numbers from a List[Int].

def filter[A](l: List[A])(f: A => Boolean): List[A] =
  List.foldRight(l, Nil: List[A])((h, t) => if (f(h)) Cons(h, t) else t)

filter(List(1, 2, 3, 4, 5, 6, 7))(x => x % 2 == 0)

// Exercise 3.20
// Write a function flatMap that works like map except that the function given will return
// a list instead of a single result, and that list should be inserted into the final resulting
// list. Here is its signature:
// def flatMap[A,B](as: List[A])(f: A => List[B]): List[B]
// For instance, flatMap(List(1,2,3))(i => List(i,i)) should result in
// List(1,1,2,2,3,3).

def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] =
  concat(map(as)(f))

flatMap(List(1,2,3))(i => List(i,i))


