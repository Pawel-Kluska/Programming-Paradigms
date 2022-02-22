(*Pawel Kluska nr 260391*)

(*zadanie 1*)
let rec flatten1 xss = 
    if xss = [] then []
    else List.hd xss @ flatten1 (List.tl xss);;

flatten1[[1;2];[3;4;5]];;
flatten1[];;

(*Zadanie 2*)
let rec count(x1, xs)= 
  if xs = [] then 0
  else (if List.hd xs = x1 then 1 else 0)
       + count(x1, List.tl xs);;

count('a',['a';'b';'a']);;
count(1.,[2.;2.;2.]);;
count(1,[1;1;1]);;

(*Zadnie 3*)
let rec replicate (x,n)= 
    if n < 0 then failwith "Ujemny argument"
    else if n=0 then []
    else  x :: replicate(x,n-1);;

replicate("z",6);;
replicate(3,5);;
replicate(1.,-1);;
replicate(5,0);;

(*Zadnie 4*)
let rec sqrList xs =
  if xs = [] then []
  else List.hd xs * List.hd xs :: sqrList (List.tl xs) ;;

sqrList [1;-2;3;-4];;
sqrList[];;

(*Zadanie 5*)
let palindrome xs =
  if xs = (List.rev xs) then true
  else false;;

palindrome["a";"l";"a"];;
palindrome[];;
palindrome['a';'b';'c'];;

(*Zadanie 6*)
let rec listLength xs =
  if xs = [] then 0
  else 1 + listLength(List.tl xs);;

listLength [1;2;3;4];;
listLength [];;
listLength ["a","b"];;

