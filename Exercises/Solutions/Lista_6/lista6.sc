//Pawel Kluska nr 260391

var count2 = 0
while count2 < 3 do
  println(count2)
  count2 += 1

//Zadanie 1

def whileLoop(condition: =>Boolean)(expression: =>Unit): Unit =
  if condition then
    expression
    whileLoop(condition)(expression)


var count = 0
whileLoop (count<3) ({
  println(count)
  count += 1})

//Zadanie 2

def swap(tab: Array[Int])(i: Int)(j: Int) =
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux


def choose_pivot(tab: Array[Int])(m: Int)(n: Int) =
  tab((m+n)/2)


def partition(tab:Array[Int])(l:Int)(r:Int) =
  var i = l
  var j = r
  val pivot = choose_pivot(tab)(l)(r)

  while i <= j do
    while (tab(i) < pivot) do
      i += 1
    while pivot < tab(j) do
      j -= 1

    if i <= j then
      swap(tab)(i)(j)
      i += 1
      j -= 1

  (i, j)



def quick(tab: Array[Int])(l: Int)(r: Int): Unit =
  if (l < r)
    val (i, j) = partition(tab)(l)(r)
    if (j - l < r - i) then
      val _ = quick(tab)(l)(j)
      quick(tab)(i)(r)

    else
      val _ = quick(tab)(i)(r)
      quick(tab)(l)(j)



def quicksort(tab: Array[Int]) = quick(tab)(0)(tab.length - 1)

val t1 = new Array[Int](6)
t1(0) = 6
t1(1) = 2
t1(2) = 5
t1(3) = 4
t1(4) = 3
t1(5) = 1


partition(t1)(2)(5) == (4,3)

choose_pivot(t1)(1)(5) == 3

quicksort(t1)
t1.toList == List(1,2,3,4,5,6)


swap(t1)(0)(1)
t1.toList == List(2,1,3,4,5,6)