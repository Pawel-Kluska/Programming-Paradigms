def reverse4[A,B,C,D](x: (A,B,C,D)) ={
  (x._4,x._3,x._2,x._1)
}

val test = (1,2,3,4)
val test2 = ("a",4,8.0,8)
reverse4(test)
reverse4(test2)

def substitute[A] (xs : List[A], a:A, b:A) : List[A] ={
  if xs == Nil then Nil
  else if xs.head == a then b :: substitute(xs.tail, a, b)
  else xs.head :: substitute(xs.tail, a, b)
}

substitute(List(2,4,6,2,2), 2, 9)
substitute(List(2.1,4.0,6.3,2.1,2.8,2.1), 2.1, 9.0)

def insert[A] (xs:List[A], a:A, b:Int) : List[A] ={
  if(b <= 0) then a :: xs
  else if (xs == Nil) then a :: Nil
  else xs.head :: insert(xs.tail, a, b-1)
}

insert(List(1,2,3,4,5,6), 10, 15)
insert(List(1.9,2.3,3.5,4.7,5.2,6.8), 10.5, 3)
insert(List("a","b","c","d","e"), "z",-4);;