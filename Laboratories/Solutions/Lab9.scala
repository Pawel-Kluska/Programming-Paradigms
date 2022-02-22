object Testy:

  def main(args: Array[String]) =

    val r1 = new Rectangle(1,5)
    println("First " + r1.firstEdge)
    println("Second " + r1.secondEdge)
    println("Area " + r1.area)

    val s1 = new Rectangle(3)
    println("First " + s1.firstEdge)
    println("Second " + s1.secondEdge)
    println("Area " + s1.area)

    val h1 = new HandyMan("Jan", "Kowalski", 45) with fixElectricity with fixSink
    Electrician.add
    Plumber.add

    val h2 = new HandyMan("Stanislaw", "Nowak", 21) with paint
    Painter.add

    val h3 = new HandyMan("Jacek", "Janicki", 34) with paint with fixSink with build
    Mason.add
    Plumber.add
    Painter.add

    h3.fixSink()
    h3.paintWalls()
    h3.buildHouse()

    Electrician.message
    Plumber.message
    Painter.message
    Mason.message

    try
      val h4 = new HandyMan("","Strzala",23)
    catch
      case e1 : WrongName => println("Zle imie")
      case e2 : WrongSurname => println("Zle Nazwisko")
      case e1 : WrongAge => println("Zly wiek")

    try
      val h5 = new HandyMan("Zbigniew","Strzala",15)
    catch
      case e1 : WrongName => println("Zle imie")
      case e2 : WrongSurname => println("Zle Nazwisko")
      case e1 : WrongAge => println("Zly wiek")

end Testy

//Zadanie 1
class Rectangle(private val a : Double, private val b : Double) :

  def this(a: Double) =
    this(a, a)

  def firstEdge: Double = a
  def secondEdge: Double = b

  def area: Double = a*b

end Rectangle

//Zadanie 2
class WrongName extends Exception
class WrongSurname extends Exception
class WrongAge extends Exception

trait fixElectricity:
  def fixElectricity() =
    println("Umiem naprawiac gniazdka")

trait paint:
  def paintWalls() =
    println("Umiem pomalowac sciany")

trait build:
  def buildHouse() =
    println("Umiem zbudowac dom")

trait fixSink:
  def fixSink() =
    println("Umiem naprawic zlew")


class HandyMan(private val n : String, private val s : String, private val a : Int) :

  if(n == "") then throw new WrongName
  if(s == "") then throw new WrongSurname
  if(a < 18) then throw new WrongAge

  def name: String = n
  def surname: String = s
  def age: Int = a

end HandyMan

object Electrician :
  private var counter = 0
  def add: Unit = counter += 1
  def message: Unit = println("Ilosc elektrykow wynosi " + counter)


object Painter :
  private var counter = 0
  def add: Unit = counter += 1
  def message: Unit = println("Ilosc malarzy wynosi " + counter)


object Mason :
  private var counter = 0
  def add: Unit = counter += 1
  def message: Unit = println("Ilosc murarzy wynosi " + counter)


object Plumber :
  private var counter = 0
  def add: Unit = counter += 1
  def message: Unit = println("Ilosc hydraulikow wynosi " + counter)



