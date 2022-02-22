//Pawel Kluska

//Przygotowanie drzew binarnych

sealed trait BT[+A]
  case object Empty extends BT[Nothing]
  case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

val t1 = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty))
val t2 =  Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty)

//Zadanie 3

def breadthBT[A](n:BT[A]) : List[A] =
  def helper[A](nodeQueue: List[BT[A]]): List[A] =
    nodeQueue match
      case Nil => Nil
      case Empty :: t => helper(t)
      case Node(a, left, right) :: t => a :: helper(t ::: List(left, right))

  helper(List(n))


breadthBT(t1) == List(1,2,3,4,5,6)
breadthBT(t2) == List(1,2,3)

//Zadanie 4

def internalPath[A](n:BT[A]) : Int =
  def helper[A](b:BT[A], depth:Int) : Int =
    b match
      case Empty => 0
      case Node(_,left,right) => depth + helper(left,depth+1) + helper(right,depth+1)

  helper(n,0)


internalPath(t1) == 9
internalPath(t2) == 3

def externalPath[A](n:BT[A]) : Int =
  def helper[A](b:BT[A], depth:Int) : Int =
    b match
      case Empty => depth
      case Node(_,left,right) => helper(left,depth+1) + helper(right,depth+1)

  helper(n,0)


externalPath(t1) == 21
externalPath(t2) == 9

//Przygotowanie grafow

sealed trait Graphs[A]
 case class Graph[A](succ: A=>List[A]) extends Graphs[A]

val g = Graph((i: Int) =>
   i match
     case 0 => List(3)
     case 1 => List(0, 2, 4)
     case 2 => List(1)
     case 3 => Nil
     case 4 => List(0, 2)
     case n => throw new Exception(s"Graph g: node $n doesn't exist")

 )

val s = g succ 2

//Zadanie 5

def depthSearch[A](g: Graph[A], startNode:A) =
  def search(queue: List[A], visited: List[A]): List[A] =
    queue match
      case Nil => Nil
      case h :: t =>
        if visited contains h then search(t, visited)
        else h :: search((g succ h) ::: t, h :: visited)

  search(List(startNode), Nil)


depthSearch(g,2) == List(2,1,0,3,4)
depthSearch(g,4) == List(4,0,3,2,1)

