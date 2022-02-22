class Point(var x:Double = 0.0, var y:Double = 0.0) :
  override def toString = s"[$x, $y]"

import java.awt.Color
import scala.collection.immutable.Queue


class Pixel(xp:Double=0.0, yp:Double=0.0, var color:Color = Color.BLACK) extends Point(xp, yp):
  override def toString = super.toString + " " + color


class TopSecretMessage(val s:String) :

  override def toString = s"Wiadomosc scisle tajna: $s"

class EncryptedMessage(s:String) extends TopSecretMessage(s):
  override def toString = s"Wiadomosc srednio zaszyfrowana: $s"

class PlainTextMessage(s:String) extends EncryptedMessage(s):
  override def toString = s"Wiadomosc jawna : $s"


class Channel[M](val queue : Queue[M]) :

  def send[M](message : M) =
    println("Sending: " + message.toString())
    new Channel(queue.enqueue(message))

  def received =
    if(queue.size == 0) then
      this
    else
      println("Receiving: " + queue.front)
      new Channel(queue.dequeue(1))



object Main {
  def main(args: Array[String]) =
    var listOfPoints : List[Point] = new Point(1,2) :: new Point(2,3) :: Nil
    var listOfPixels : List[Pixel] = new Pixel(3,4) :: new Pixel(5,6) :: Nil
    var listOfPoints2 = listOfPoints

    listOfPoints = listOfPixels
    println("Kowariancja zachodzi")
    // listOfPixels = listOfPoints2
    // Blad typow : Required: List[Pixel] Kontrawariancja nie zachodzi
    // Gdyby oba nie zachodzily lista bylaby inwariantna

    val q = Queue[TopSecretMessage](new TopSecretMessage("m1"), new PlainTextMessage("m2"))
    var channelTop = new Channel[TopSecretMessage](q)

    val c1 = channelTop.received
    val c2 = c1.received

}