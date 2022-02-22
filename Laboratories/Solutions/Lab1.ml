let reverse4 (a,b,c,d)  =
  (d,c,b,a);;

let test=(1,"a",3.0,4);;

reverse4 test;;

let rec substitute (xs,a,b) =
  if xs = [] then []
  else if List.hd xs = a then b :: substitute(List.tl xs, a, b)
  else List.hd xs :: substitute (List.tl xs, a, b);;

let test2 = ([1;3;5;7;3;3], 3, 10);;
substitute test2;;
let test6  = ([1.;3.;5.;7.;3.;3.], 3., 10.);;
substitute test6;;

let rec insert (xs, a, b) =
  if(b <= 0) then a :: xs
  else if xs = [] then a :: []
  else List.hd xs :: insert(List.tl xs, a, b-1);;

let test3 = ([1;2;3;4;5;6;7;8;9], 3, 5);;

let test4 = (["a";"b";"c";"d";"e"], "z",2);;

let test5 = ([1.;2.;3.;4.;5.;6.;7.;8.;9.;],10.0,15);;


insert test2 ;;
insert test4 ;;
insert test5 ;;

