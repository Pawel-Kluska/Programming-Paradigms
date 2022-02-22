//Pawel Kluska nr 260391


//Zadanie 1
class Time1(private var h : Int) :
  if (h < 0) h = 0

  def hour: Int = h

  def hour_=(newHour: Int) =
    if (newHour < 0) h = 0
    else h = newHour

end Time1

//Zadanie 2a
class Time2a(private var h : Int, private var m : Int) :

  require(0 <= h && h < 24)
  require(0 <= m && m < 60)

  def hour: Int = h

  def hour_=(newHour: Int) =
    require(0 <= newHour && newHour < 24)
    h = newHour

  def minute: Int = m

  def minute_=(newMinute: Int) =
    require(0 <= newMinute && newMinute < 60)
    m = newMinute


  def before(other: Time2a): Boolean =
    h < other.h || h == other.h && m < other.m

end Time2a

//Zadanie 2b
class Time2b(h: Int, m: Int) :

  require(0 <= h && h < 24)
  require(0 <= m && m < 60)

  private var minutes_After_Midnight = h * 60 + m

  def hour: Int = minutes_After_Midnight / 60

  def hour_=(newHour: Int) : Unit =
    require(0 <= newHour && newHour < 24)
    minutes_After_Midnight = minute + newHour * 60


  def minute: Int = minutes_After_Midnight % 60

  def minute_=(newMinute: Int) : Unit =
    require(0 <= newMinute && newMinute < 60)
    minutes_After_Midnight = hour + newMinute


  def before(other: Time2b): Boolean =
    minutes_After_Midnight < other.minutes_After_Midnight

end Time2b

//Zadanie 3
class Pojazd (val producent: String, val model: String, val rok: Int = -1, var rejestracja: String = ""):

  def this(producent: String, model: String, rejestracja: String) =
    this(producent, model, -1, rejestracja)

end Pojazd

object Testy:

  def main(args: Array[String]) =

    //Test Zadania 1
    Test1()

    //Test Zadanie 2a
    Test2a()

    //Test Zadanie 2b
    Test2b()

    //Test Zadanie 3
    Test3()

    //Test Zadanie 4
    try
      metoda1()

    catch
      case e: Exception =>
        System.err.println(e.getMessage + "\n")
        e.printStackTrace()

  def metoda1() =
    metoda2()

  def metoda2() =
    metoda3()

  def metoda3() =
    throw new Exception("Wyjatek zgloszony w metoda3")

  //   Wyjatek zgloszony w metoda3

  // java.lang.Exception: Wyjatek zgloszony w metoda3
  //   at Testy$.metoda3(Lista9.scala:35)
  // at Testy$.metoda2(Lista9.scala:32)
  // at Testy$.metoda1(Lista9.scala:29)
  // at Testy$.main(Lista9.scala:21)
  // at Testy.main(Lista9.scala)



  //Test Zadanie 1
  def Test1() =
    val t1 = Time1(4)
    val t2 = Time1(-5)

    println(t1.hour)
    println(t2.hour)

    t2.hour = 5
    println(t2.hour)
    println()

  //Test Zadania 2a
  def Test2a() =
    val t1 = Time2a(4,36)
    val t3 = Time2a(2,45)

    println(t3.hour)
    t3.hour = 1
    println(t3.hour )
    println(t3.before(t1))

    try
      val t2 = Time2a(-5,90)
    catch
      case e: Exception =>
        System.err.println("Bledne dane" + "\n")

    println()

  //Test Zadania 2b
  def Test2b() =
    val t1 = Time2b(4,36)
    val t3 = Time2b(2,45)

    println(t3.hour)
    t3.hour = 1
    println(t3.hour )
    println(t3.before(t1))

    try
      val t2 = Time2b(-5,90)
    catch
      case e: Exception =>
        System.err.println("Bledne dane" + "\n")

    println()

  //Test Zadania 3
  def Test3() =
    new Pojazd("Opel", "Astra", 2016, "EWI123")
    new Pojazd("Volkswagen", "Golf", 2000)
    new Pojazd("Ford", "Focus", "ESI123")
    new Pojazd("Renault", "Clio")

end Testy
