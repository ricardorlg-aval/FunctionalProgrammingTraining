package chapter3

import scala.annotation.tailrec

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 0
    case Cons(0.0, _) => 0.0
    case Cons(h, t) => h * product(t)
  }

  // exercise 3.2
  def tail[A](l: List[A]): List[A] =
    l match {
      case Nil => sys.error("tail of empty list")
      case Cons(_, t) => t
    }

  // exercise 3.3
  //implement the function setHead for replacing the first element
  //of a List with a different value.

  def setHead[A](xs: List[A],value: A): List[A] = xs match {
    case Nil => Cons(value, Nil)
    case Cons(_, t) => Cons(value, t)
  }

  // exercise 3.4
  def drop[A](l: List[A], n: Int): List[A] = n match {
    case 0 => l
    case _ => drop(tail(l),n-1)
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def foldRight [A,B](as: List[A], z:B)(f: (A,B) => B):B = as match {
    case Nil => z
    case Cons(h,t) => f(h,foldRight(t,z)(f))
  }
  def length [A] (as: List[A]): Int = as match {
    case Nil => 0
    case Cons(h,t) => List.foldRight(as,0)((_,y)=> y + 1 )
  }

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h,t) => foldLeft(t, f(z,h))(f)
  }


  def reverse [A](as: List [A]): List[A] = as match {
    case Nil => Nil
    case Cons(h,t) => foldLeft(as, Nil:List[A])((z,x) => Cons(x,z))
  }

}
