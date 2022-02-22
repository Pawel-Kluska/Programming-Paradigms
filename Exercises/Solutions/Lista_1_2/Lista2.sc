//Pawel Kluska nr 260391

//Zadanie 2a

def fib1 (n:Int) : Int = {
  if n == 0 then 0
  else if n == 1 then 1
  else fib1(n-2) + fib1(n-1)
}

fib1(0)
fib1(1)
fib1(12)

//Zadanie 2b

def fib2(n:Int) = {
  def fib2t(n:Int, acum1:Int, acum2:Int):Int = {
    n match {
      case 0 => acum1
      case 1 => acum2
      case _ => fib2t(n - 1, acum2, acum2 + acum1)
    }
  }
  fib2t(n, 0, 1)
}
fib2(10)


//zadanie 3 metoda
def root3(a: Double) = {
  def root3Tail(x:Double): Double =
    if math.abs(math.pow(x,3)-a)<=1.0E-15*math.abs(a) then x
    else root3Tail(x + (a/math.pow(x,2)-x)/3)

  if a > 1 then root3Tail(a/3) else root3Tail(a)
}

//zadanie 3 funkcja

val root3Fun = root3 _

root3(64)
root3(125)
root3(1)
root3Fun(72)

//Zadanie 4a

val a = List(-2,1,0,1,2)
val List(_,_,x,_,_) = a

//Zadanie 4b
val b = List((1,2), (0,1))
val List((_,_), (x2,_)) = b

//Zadanie 5
def initSegment[A](xs: List[A], ys: List[A]): Boolean ={
  (xs,ys) match
    case (Nil, _) => true
    case (_, Nil) => false
    case (h1::t1,h2::t2) => if h1 == h2 then initSegment(t1,t2) else false
}

initSegment(List(1,2,3,4,5),List(1,2,3,4,5,6))
initSegment(List(1,2,3,4,5),List(1,2,3,4,8,2))
initSegment(List(),List(1,2,3,4,5,6))
initSegment(List(1,2,3,4,5),List())

//Zadanie 6a
def replaceNth[A](xs: List[A], n: Int, x: A): List[A] ={
  (xs,n) match {
    case (Nil,_) => throw new Exception("Nieprawidlowy argument")
    case (h::t,0) => x :: t
    case (h::t, _) => h :: replaceNth(t,n-1,x)
  }
}

replaceNth(List(1,2,3,4),0,10)
replaceNth(List(),0,8.2)
replaceNth(List("a","b","c","d"),3,"b")


