//Zadanie 1
sealed trait tree3[+A]
case object Empty extends tree3[Nothing]
case class Node[+A](elem: A, left: tree3[A], middle: tree3[A], right: tree3[A]) extends tree3[A]


def mapTree3[A,B](f: A=>B)(t:tree3[A]) : tree3[B] ={
  t match {
    case Empty => Empty
    case Node(e,l,m,r) => Node(f(e),mapTree3(f)(l),mapTree3(f)(m),mapTree3(f)(r))
  }
}

val t1 = Node(1,Node(2,Node(4,Empty,Empty,Empty),Node(7,Empty,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty,Empty),Node(2,Empty,Empty,Empty)),Empty,Empty),Node(3,Empty,Empty,Empty))

val t2 = Node(1.0,Node(2.0,Node(4.0,Empty,Empty,Empty),Node(7.0,Empty,Empty,Empty),Empty),Node(3.0,Node(5.0,Empty,Node(6.0,Empty,Empty,Empty),Node(2.0,Empty,Empty,Empty)),Empty,Empty),Node(3.0,Empty,Empty,Empty))
val f1 = (a:Int) => a+5
val f2 = (a:Double)=> a+5

mapTree3(f1)(t1)
mapTree3(f2)(t2)
mapTree3(f1)(Empty)

//Zadanie 2

    case class Word(li : String)

  sealed trait sentence
    case class Constative(wy: List[Word]) extends sentence
    case class Exclamatory(wy: List[Word]) extends sentence
    case class Question(wy: List[Word]) extends sentence

    case class Text(zd:List[sentence])


val s = Text(List( Constative( List(Word("ala"),Word("ma"),Word("kota"))), Exclamatory (List(Word("ala"),Word("ma"),Word("kota")))))

val s2 = Constative( List(Word("ala"),Word("ma"),Word("kota")))


def sentenceToString(z:sentence)  = {
  def help(wy: List[Word],o:String) : String = {
    wy match
     case Nil => o
     case Word(s) :: t => s + " " + help(t,o)
  }

  z match
    case Constative(wy) => help(wy,".")

    case Exclamatory(wy) => help(wy,"!")

    case Question(wy) => help(wy,"?")

}

sentenceToString(s2);;

