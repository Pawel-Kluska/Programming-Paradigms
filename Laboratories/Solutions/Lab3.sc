def revNCamp[A](f: A=>A)(n:Int) = {
  (x: A) =>
  def revNCamp2(f: A => A)(n: Int)(x: A)(l: List[A]): List[A] = {
    if n <= 0 then l
    else if n == 1 then l
    else revNCamp2(f)(n - 1)(f(x))(f(x) :: l)
  }

  revNCamp2(f)(n)(x)(List[A](x))
}
val funct1 = (x:Int) => 2*x
val funct2 = (x:String) => x + "n"
val funct3 = (x:Double) => 2+x

revNCamp(funct1)(10)(1)
revNCamp(funct2)(5)("n")
revNCamp(funct3)(6)(1)

def area (a:Double,b:Double)(f: Double=>Double)(n:Int) : Double = {
    val width = (b - a) / n
    val base = List.range(0, n) //iteratory

    width * ((base foldLeft 0.0) ((sum, i) => sum + f(a + i * width + width/2)))
  }

area (0,3.1415)((n:Double) => scala.math.sin(n))(10000)
area (-12,2)((n:Double) => n*n+2*n+12)(10000)
area (-5,5)((n:Double) => n)(100)