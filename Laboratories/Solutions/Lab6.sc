def modifiedPascalF(n:Int) = {
  def pascalHelper(xs: List[Int], k: Int): List[Int] = {
    (xs, k) match
      case (h1 :: Nil, _) => Nil
      case (h1 :: h2 :: t, k) if k % 2 == 0 => h1 + h2 :: pascalHelper(h2::t, k)
      case (h1 :: h2 :: t, k) if k % 2 == 1 => h1 - h2 :: pascalHelper(h2::t, k)
      case (_,_) => throw new Exception("Internal error")

  }

  def pascalHelper2(xs: List[Int], row: Int): List[Int] = {
    if row < n then pascalHelper2(1 :: pascalHelper(xs, row)::: List(1), row + 1)
    else 1 :: pascalHelper(xs, row)::: List(1)
  }

  if n<0 then
    List()
  else if n==0 then
    List(1)
  else if n==1 then
    List(1,1)
  else pascalHelper2(List(1,1),2)
}

def modifiedPascalI(n:Int) = {

  var t1 = new Array[Int](0)

  if (n<0) {}
  else if(n==0) then
     t1 = Array.fill(1)(1)
  else if(n == 1) then
     t1 = Array.fill(2)(1)
  else
    var row = 2
    t1 = Array.fill(2)(1)

    while(row <= n) do {
      var i = 1
      var array = new Array[Int](row + 1)

      while (i < array.length - 1) do {
        if (row % 2 == 0) then
          array(i) = t1(i-1) + t1(i)
        else
          array(i) = t1(i-1) - t1(i)
        i += 1
      }

      array(0) = 1
      array(array.length - 1) = 1
      t1 = array
      row += 1
    }
  t1
}

modifiedPascalF(1)
modifiedPascalF(5)
modifiedPascalF(-1)
modifiedPascalI(1).toList
modifiedPascalI(5).toList
modifiedPascalI(-1).toList


