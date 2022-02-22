//Pawel Kluska nr 260391

//Zadanie 1
def lrepeat[A](k:Int)(list:LazyList[A]):LazyList[A] =
  def helper(reps:Int, rest:LazyList[A]):LazyList[A] =
    (reps, rest) match
    case (_, LazyList()) => LazyList()
    case (0, _ #:: tail) => helper(k, tail)
    case (_, head #:: _) => head #:: helper(reps - 1, rest)

  helper(k, list)

lrepeat(3)(LazyList('a','b','c','d')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()
lrepeat(5)(LazyList(1,2)).take(10).toList == List(1, 1, 1, 1, 1, 2, 2, 2, 2, 2)

//Zadanie 2
val fib2 =
  def fib2t(acum1:Int, acum2:Int):LazyList[Int] =
    acum1 #:: fib2t(acum2,acum1+acum2)
  fib2t(0,1)


fib2.take(15).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
fib2.take(5).toList == List(0, 1, 1, 2, 3)
fib2.take(20).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)


//Zadanie 3
sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

// a)
def lBreadth[A](n:lBT[A]) : LazyList[A] =
  def helper[A](nodeQueue: List[lBT[A]]): LazyList[A] =
    nodeQueue match
      case Nil => LazyList()
      case LEmpty :: t => helper(t)
      case LNode(a, left, right) :: t => a #:: helper(t ::: List(left(), right()))

  helper(List(n))

val ltree =  LNode(1,()=>LNode(2,()=>LEmpty,()=>LNode(3,()=>LEmpty,()=>LEmpty)),()=>LEmpty)
lBreadth(ltree).toList == List(1,2,3)

// b)
def lTree (n:Int) : lBT[Int] =
  LNode(n,()=>lTree(2*n),()=>lTree(2*n+1))

lBreadth(lTree(1)).take(20).toList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
lBreadth(LEmpty).take(20).toList == List()