(*Pawel Kluska*)
(*Modul*)

type 'a t = {a : 'a option array; mutable f : int; mutable r : int};;
exception Empty of string;;
exception Full of string;;

let empty n =
  { a = Array.make (n+1) None; f = 0; r = 0}

let isFull q =
  q.f = (q.r+1) mod (Array.length q.a)

let isEmpty q =
      
  q.r = q.f

let enqueue (elem,q) =
  if(isFull q) then
    raise(Full  "module CyclicArrayQueue: enqueue")
  else
    begin q.a.(q.r) <- Some(elem);
          q.r <- (q.r +1) mod (Array.length q.a)
    end
                   
let dequeue q =
  if(isEmpty q) then
    ()
  else
    q.f <- (q.f+1) mod (Array.length q.a)
            
let first q =
  if(isEmpty q) then
    raise(Empty  "module CyclicArrayQueue: first")
  else
    match q.a.(q.f) with
      Some v -> v
     |None -> failwith "module CyclicArrayQueue: first (implementation error!!!)"


            
