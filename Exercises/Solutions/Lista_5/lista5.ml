(*Pawel Kluska nr 260391*)

type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs))
;;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs)
;; 

let rec lzip (lxs, lys) =
  match (lxs, lys) with
    (LCons(h1, lazy t1), LCons(h2, lazy t2)) -> LCons((h1, h2), lazy (lzip (t1, t2)))
  | _ -> LNil
;;

(*Zadanie 1*)

let lrepeat k llist = 
  let rec helper(reps, rest) = match (reps, rest) with
    | (_, LNil) -> LNil
    | (0, LCons(_, lazy tailFunction)) -> helper(k, tailFunction)
    | (_, LCons(head, _)) -> LCons(head, lazy (helper(reps - 1, rest)))
  in helper(k, llist)
;;


let test1 = LCons(1,lazy(LCons(2,lazy(LNil))));;
let test2 = LCons('a',lazy(LCons('b',lazy(LCons('c',lazy(LCons('d',lazy(LNil))))))));;

ltake (12 ,lrepeat 3 test2) = ['a'; 'a'; 'a'; 'b'; 'b'; 'b'; 'c'; 'c'; 'c'; 'd'; 'd'; 'd'];;
ltake (15 ,lrepeat 3 (lfrom 1)) = [1;1;1;2;2;2;3;3;3;4;4;4;5;5;5];;
ltake (15 ,lrepeat 3 (LNil)) = [];;
ltake (15 ,lrepeat 5 test1) = [1; 1; 1; 1; 1; 2; 2; 2; 2; 2];;

(*Zadanie 2*)

let fib2 =
  let rec fib2t ac1 ac2 =
    LCons(ac1,lazy(fib2t ac2 (ac1+ac2)))
  in
  fib2t 0 1
;;

ltake(10, fib2) = [0; 1; 1; 2; 3; 5; 8; 13; 21; 34];;
ltake(5, fib2) = [0; 1; 1; 2; 3];;
ltake(20, fib2) = [0; 1; 1; 2; 3; 5; 8; 13; 21; 34; 55; 89; 144; 233; 377; 610; 987; 1597;
 2584; 4181];;

(*Zadanie 3*)
type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;

(* a) *)
let lBreadth lbt =
  let rec search nodeQueue =
    match nodeQueue with
      [] -> LNil
    | LEmpty :: t -> search t
    | LNode(a,left,right) :: t -> LCons(a, lazy(search (t @ [left();right()])))
  in
  search [lbt]
;;

let ltree = LNode(1,(fun()->LNode(2,(fun()->LEmpty),(fun()->LNode(3,(fun()->LEmpty),(fun()->LEmpty))))),(fun()->LEmpty));;

ltake (3, lBreadth ltree) = [1; 2; 3];;

(* b) *)

let rec lTree n =
  LNode(n, (fun()->lTree(2*n)), (fun()->lTree(2*n+1)))
;;

ltake (20, lBreadth (lTree 1)) = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20];;
ltake (20, lBreadth LEmpty) = [];;



        
