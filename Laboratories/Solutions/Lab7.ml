type instruction' = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div


module StackMachine =
  struct
    type t = { mutable l : float list }
    exception Lack_Of_Args of string
    exception Divide_By_Zero of string
    type instruction = instruction'

                              
    let init() = { l = [] }

    let rst(s) = s.l <-[]

    let loadF(s,f) = s.l <- f :: s.l

    let loadI(s,i) = s.l <- (float_of_int i) :: s.l

    let cpy(s) =
      match s.l with
        h::t -> s.l <- h::s.l
      | [] -> raise (Lack_Of_Args "module StackMutList: cpy")
      
    let add(s) =
      match s.l with
        [] -> raise (Lack_Of_Args "module StackMutList: add")
       |h::[] ->  raise (Lack_Of_Args "module StackMutList: add")
       |h1::h2::t -> s.l <- (h1+.h2) :: t

    let sub(s) =
      match s.l with
        [] -> raise (Lack_Of_Args "module StackMutList: sub")
       |h::[] ->  raise (Lack_Of_Args "module StackMutList: sub")
       |h1::h2::t -> s.l <- (h1-.h2) :: t

    let mul(s) =
      match s.l with
        [] -> raise (Lack_Of_Args "module StackMutList: mul")
       |h::[] ->  raise (Lack_Of_Args "module StackMutList: mul")
       |h1::h2::t -> s.l <- (h1*.h2) :: t

    let div(s) =
      match s.l with
        [] -> raise (Lack_Of_Args "module StackMutList: div")
       |h::[] ->  raise (Lack_Of_Args "module StackMutList: div")
       |h1::0.::t -> raise (Divide_By_Zero "module StackMutList: div")
       |h1::h2::t -> s.l <- (h1/.h2) :: t


    let result(s) =
       match s.l with
        [] -> None
       |h::t -> Some(h)

    let rec execute(s,list) =
      match list with
        [] -> ()
      | Rst :: t -> rst(s) ; execute(s,t)
      | LoadF(f) :: t -> loadF(s,f) ; execute(s,t)
      | LoadI(i) :: t -> loadI(s,i) ; execute(s,t)
      | Cpy :: t -> cpy(s) ; execute(s,t)
      | Add :: t -> add(s) ; execute(s,t)
      | Sub :: t -> sub(s) ; execute(s,t)
      | Mul :: t -> mul(s) ; execute(s,t)
      | Div :: t -> div(s) ; execute(s,t)
                    
  end;;



module type COPROCESSOR =
  sig
    type t
    exception Lack_Of_Args of string
    exception Divide_By_Zero of string
    type instruction 
    val init : unit -> t
    val result : t -> float option
    val execute : t * instruction list -> unit
    
  end;;

module Coprocessor = (StackMachine:COPROCESSOR with type instruction = instruction');;

let list = [LoadF(0.) ;LoadF(6.6) ;LoadI(1);Add;Div;Sub];;
let s = Coprocessor.init();;

Coprocessor.execute(s,list);;
Coprocessor.result(s);;

let list2 = [Add;Div];;
Coprocessor.execute(s,list2);;
Coprocessor.result(s);;



