//Pawel Kluska

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object zad2a :

  def pairFut[A, B](fut1: Future[A], fut2: Future[B]): Future[(A, B)] =
    fut1.zip(fut2)

  def main(args: Array[String]) =
    val f = Future {
      Thread.sleep(1000)
      4 + 3
    }
    val f2 = Future {
      Thread.sleep(1000)
      "Test"
    }

    val s = pairFut(f, f2)
    println(s)
    Thread.sleep(1500)
    println(s)


///////////////////////////////////////////////////////////////////////////////
object zad2b :
  def pairFut[A, B] (fut1: Future[A], fut2: Future[B]): Future[(A, B)] =
    for
      x <- fut1
      y <- fut2
    yield (x,y)

  def main(args: Array[String]) =
    val f = Future {
      Thread.sleep(1000)
      4 + 3
    }

    val f2 = Future {
      Thread.sleep(1000)
      "Test"
    }

    val s = pairFut(f, f2)
    println(s)
    Thread.sleep(1500)
    println(s)


