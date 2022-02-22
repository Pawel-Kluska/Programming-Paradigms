def sublistsL[A](list:LazyList[A]) =
  def makeSublist(n: Int, rest: LazyList[A]): List[A] = {
    (n, rest) match
      case (_, LazyList()) => Nil
      case (0, _) => Nil
      case (_, head #:: tail) => head :: makeSublist(n - 1, tail)
  }

  def makeLazyList(n:Int) : LazyList[List[A]] =
    if(makeSublist(n-1,list) != makeSublist(n,list)) then makeSublist(n,list) #:: makeLazyList(n+1)
    else  LazyList()

  makeLazyList(1)

val lazyL1 = LazyList(1,2,3,4,5,6)
val lazyL3 = LazyList()
val lazyL2 = LazyList.from(1)

val l1 = sublistsL (lazyL1).toList
val l2 = sublistsL (lazyL2).take(15).toList
val l3 = sublistsL (lazyL2).take(0).toList
val l4 = sublistsL(lazyL3).toList



