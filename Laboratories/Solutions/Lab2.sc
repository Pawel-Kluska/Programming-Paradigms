def find[A] (xs:List[A]) (x:A) : Boolean = {
  xs match {
    case (h :: t) if h == x => true
    case (h :: t) if h != x => find(t) (x)
    case Nil => false
  }
}

find (List(1,2,3,4)) (0)

def find123[A] (x:A) = find(List(1.0,2.0,3.0)) (x)
find123(2.0)
find123(8.0)

def split2Rec[A] (xs:List[A]) : (List[A],List[A]) = {
  def split2Rec2[A] (xs:List[A], l:Int) : (List[A],List[A]) = {
    (xs,l) match {
      case (Nil,_) => (Nil, Nil)
      case (h::t,1) =>
        val (a,b) = split2Rec2(t,0)
        (h::a,b)
      case (h::t,0) =>
        val (a,b) = split2Rec2(t,1)
        (a,h::b)
    }
  }
  split2Rec2(xs,1)
}

split2Rec(List(1,2,3,4,5))

def split2Tail[A] (xs:List[A]) : (List[A],List[A]) = {
  def split2Tail2[A] (xs:List[A], w:(List[A],List[A]), l:Int) : (List[A],List[A]) = {
    val (a,b) = w
    (xs,l) match {
      case (Nil,_) => w
      case (h::t,1) => split2Tail2(t,(h::a, b),0)
      case (h::t,0) => split2Tail2(t,(a, h::b),1)
    }
  }
  split2Tail2(xs,(List(),List()),1)
}

split2Tail(List(1,2,3,4,5))