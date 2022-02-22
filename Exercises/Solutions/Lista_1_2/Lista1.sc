//Pawel Kluska nr 260391

//Zadanie 1
def flatten1 [A](xss: List[List[A]]):List[A] = {
  if xss == Nil then Nil
  else xss.head ::: flatten1(xss.tail)
}

flatten1(List(List(1,2,3,4,5), List(6,7,8,9)))
flatten1(List(List(), List(6.0,7.0,8.0,9.0)))

//Zadanie 2
def count [A] (x1 : A, xs : List[A]) : Int = {
  if xs == Nil then 0
  else (if xs.head == x1 then 1 else 0) + count(x1, xs.tail)
}

count("a", List("a","c","a"))
count(2.2, List(3.2,7.3,6.4))
count(1, List(1,1,1))

//Zadanie 3
def replicate [A] (x2: A, n: Int): List[A] ={
  if n < 0 then throw new Exception ("Ujemny argument")
  if n==0 then Nil
  else x2 :: replicate(x2,n-1)
}

replicate("b",7)
replicate(2,3)
replicate(1.1,-6)
replicate(6,0)

//Zadanie 4 metoda

def sqrList(xs: List[Int]) : List[Int] = {
  if xs == Nil then Nil
  else xs.head*xs.head :: sqrList(xs.tail)
}

sqrList(List(1,-2,3,-4))
sqrList(List())

//zadanie 4 funkcja
val sqrListF : List[Int] = {
  xs =>
  if xs == Nil then Nil
  else xs.head*xs.head :: sqrList(xs.tail)
}
sqrListF(List(1,-2,3,-4))
sqrListF(List())

//Zadanie 5
def palindrome[A](xs: List[A]) : Boolean = {
  xs == xs.reverse
}

palindrome(List())
palindrome(List("k","a","j","a","k"))
palindrome(List("a","b","c]"))

def listLength[A](xs: List[A]):Int ={
  if xs == Nil then 0
  else 1 + listLength(xs.tail)
}

listLength(List())
listLength(List("a","b"))
listLength(List(1,2,3,4,5))


