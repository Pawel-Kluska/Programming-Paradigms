//Pawel Kluska

//Zadanie 3

def sumProd(xs: List[Int]): (Int,Int) =
  (xs foldLeft (0,1)) ((sum, x) =>
      val (a,b) = sum
      (a + x, b * x))


sumProd (List(1,2,3,4,5,6)) == (21,720)
sumProd (List(3,3,3)) == (9,27);;
sumProd (Nil) == (0,1);;

//Zadanie 5

def insertionsort[A](order:(A, A) => Boolean, list:List[A]) =
  def insert(element:A, newList:List[A]):List[A] =
    newList match
      case Nil => element::Nil
      case h :: t =>
        if order(h, element) then h :: insert(element, t)
        else  element :: newList

  (list foldLeft List[A]()) ((acc, newElement)=>insert(newElement, acc))


def isLess(first:(Int,Int), second:(Int,Int)) =
  first._1 <= second._1

insertionsort (isLess,List((1,1),(3,1),(2,1),(8,1),(4,1),(6,1))) == List((1, 1), (2, 1), (3, 1), (4, 1), (6, 1), (8, 1));;

insertionsort (isLess,List((1,1),(3,1),(2,1),(8,1),(3,2),(3,3))) == List((1, 1), (2, 1), (3, 1), (3, 2), (3, 3), (8, 1));;

def mergesort[A](order:(A, A) => Boolean, list: List[A]): List[A] =
  def merge(list1: List[A], list2: List[A]): List[A] =
    (list1, list2) match
      case (Nil, list2) => list2
      case (list1, Nil) => list1
      case (head1 :: tail1, head2 :: tail2) =>
        if (order(head1, head2)) head1 :: merge(tail1, list2)
        else head2 :: merge(list1, tail2)

  val partition = list.length / 2
  if (partition == 0) list
  else
    val (left, right) = list.splitAt(partition)
    merge(mergesort(order, left), mergesort(order, right))



mergesort (isLess,List((1,1),(3,1),(2,1),(8,1),(4,1),(6,1))) == List((1, 1), (2, 1), (3, 1), (4, 1), (6, 1), (8, 1));;

mergesort (isLess,List((1,1),(3,1),(2,1),(8,1),(3,2),(3,3))) == List((1, 1), (2, 1), (3, 1), (3, 2), (3, 3), (8, 1));;





