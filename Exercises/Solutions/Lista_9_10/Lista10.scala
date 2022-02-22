//Pawel Kluska


//Zadanie 3
class UnderflowException(msg: String) extends Exception(msg)

class PairOfListQueue[+T] private (private val queue: (List[T],List[T])) :

  def repair[S>:T](x:List[S], y:List[S]) =
     (x, y) match
       case (Nil, y) => new PairOfListQueue[S](y.reverse, Nil)
       case queue => this

  def empty () = new PairOfListQueue[T](Nil,Nil)

  def enqueue[S>:T](elem:S) = repair(queue._1, elem :: queue._2)

  def dequeue() =
    queue match
      case (Nil,_) => PairOfListQueue.empty
      case (_::t,y) => repair(t,y)

  def first() =
    queue match
      case (Nil, _) => throw new UnderflowException("PairOfListQueue: first")
      case (h::t, _) => h


object PairOfListQueue :
  def apply[T](xs: T*) = new PairOfListQueue[T](xs.toList, Nil)
  def empty[T] = new PairOfListQueue[T](Nil, Nil)

//Zadanie 4

def copy[T](dest:scala.collection.mutable.Seq[T], src:scala.collection.mutable.Seq[T]): Unit =
  require(dest.length >= src.length)
  var i = 0
    src.foreach(elem => {
      dest.update(i, elem)
      i += 1
    })

//Testy

class Point(var x:Double = 0.0, var y:Double = 0.0) :
  override def toString = s"[$x, $y]"

import java.awt.Color

class Pixel(xp:Double=0.0, yp:Double=0.0, var color:Color = Color.BLACK) extends Point(xp, yp):
  override def toString = super.toString + " " + color



object Main {

  def main(args: Array[String]): Unit =
    var queueOfPoints = PairOfListQueue(new Point(1,2), new Point(2,3))
    val queueofPoints2 = queueOfPoints.enqueue(new Pixel(5,6))
    var queueOfPixels = PairOfListQueue(new Pixel(1,2, Color.BLACK), new Pixel(2,3))
    queueOfPoints = queueOfPixels
    println(queueOfPoints.first().asInstanceOf[Pixel])

}
