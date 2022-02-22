(*Pawel Kluska*)

(*Zadanie 1*)

(*a*)
module type QUEUE_FUN =
  sig
    type 'a t
    exception Empty of string
    val empty: unit -> 'a t
    val enqueue: 'a * 'a t -> 'a t
    val dequeue: 'a t -> 'a t 
    val first: 'a t -> 'a
    val isEmpty: 'a t -> bool
  end;;

module Queue : QUEUE_FUN =
  struct
    type 'a t = 'a list
    exception Empty of string
            
    let empty () = []
    let enqueue (elem, queue) = queue @ [elem]
    let dequeue = function
        [] -> []
       |h::t -> t
              
    let first = function
        [] -> raise(Empty "module ListQueue: first")
       |h::t -> h
              
    let isEmpty queue = 
      queue = []

  end;;

(*b*)
module PairOfListsQueue : QUEUE_FUN =
  struct
    type 'a t = 'a list * 'a list
    exception Empty of string

    let repair = function
        ([],y) -> (List.rev y, [])
      | queue -> queue

    let empty () = ([],[])
    let enqueue (elem, (x,y)) = repair(x, elem :: y)
    let dequeue = function
        ([],_) ->  ([],[])
      | (h::t,y) -> repair(t,y)

    let first = function
        ([],_) ->  raise(Empty "module PairOfListQueue: first")
      | (h::t,_) -> h

    let isEmpty queue =
      queue = ([],[])
                     
  end;;


let q1 = Queue.empty();;
let q2 = Queue.enqueue(1,q1);;
let q3 = Queue.enqueue(2,q2);;
let q4 = Queue.enqueue(3,q3);;
let q5 = Queue.first(q4) = 1;;
let q6 = Queue.dequeue(q4);;
let q7 = Queue.enqueue(4,q6);;
let q8 = Queue.first(q7) = 2;;
let q9 = Queue.dequeue(q7);;
let q10 = Queue.enqueue(5,q9);;
let q11 = Queue.first(q10) = 3;;

let q1 = PairOfListsQueue.empty();;
let q2 = PairOfListsQueue.enqueue(1,q1);;
let q3 = PairOfListsQueue.enqueue(2,q2);;
let q4 = PairOfListsQueue.enqueue(3,q3);;
let q5 = PairOfListsQueue.first(q4) = 1;;
let q6 = PairOfListsQueue.dequeue(q4);;
let q7 = PairOfListsQueue.enqueue(4,q6);;
let q8 = PairOfListsQueue.first(q7) = 2;;
let q9 = PairOfListsQueue.dequeue(q7);;
let q10 = PairOfListsQueue.enqueue(5,q9);;
let q11 = PairOfListsQueue.first(q10) = 3;;

