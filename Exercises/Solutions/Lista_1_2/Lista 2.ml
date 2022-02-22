(*Pawel Kluska* nr 260391*)

(*Zadanie 2a*)

let rec fib1 n =
  if n<0 then failwith("Ujemny argument")
  else if n = 0 then 0
  else if n = 1 then 1
  else fib1(n-2) + fib1(n-1);;

fib1 10;;
fib1 22;;

(*Zadanie 2b*)

let fib2 nm =
  let rec fib2t (n, acum1, acum2) =
    match n with
      0 -> acum1
    | 1 -> acum2
    | _ -> fib2t(n-1, acum2, acum2+acum1)
  in fib2t(nm, 0, 1)
;;

fib2 10;;
fib2 22;;

(*Zadnie 3*)
let root3 a =
  let rec root x =
    if abs_float ((x*. x*. x) -. a) <= 1.0e-15 *. abs_float (a) then x
    else root (x +. (((a/.(x*.x)) -. x )/.3.))
  in
  if a > 1. then root(a/.3.)
  else root(a)
;;

root3 81.;;
root3 72.;;
root3 27.;;

(*Zadnie 4a*)
let a = [-2;1;0;1;2];;
let [_;_;x;_;_] = a;;

(*Zadanie 4b*)
let b = [(1,2);(0,1)];;
let [(_,_);(x2,_)] = b;;

(*Zadanie 5*)
let rec initSegment (xs, ys) =
  match (xs,ys) with
    ([], _) -> true
   |(_ , []) -> false
   |(h1::t1,h2::t2) -> if h1 = h2 then initSegment(t1,t2) else false
;;

initSegment([1;2;3;4],[1;2;3;4;5;6]);;
initSegment([],[1;2;3;4;5;6]);;

(*Zadnie 6a*)
let rec replaceNth(xs, n, x) =
  match (xs,n) with
     ([],_) -> raise (Failure "Nieprawidlowy argument")
    |(h::t,0) -> x :: t
    |(h::t, _) -> h :: replaceNth(t,n-1,x)
;;

replaceNth([1;2;3;4], 2, 12);;
replaceNth([1;2;3;4], 9, 12);;
