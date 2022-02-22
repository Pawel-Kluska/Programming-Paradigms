(*Pawel Kluska*)

(*Zadanie 2*)

let curry3 f x y z = f(x, y, z);;

let curry3_ = function f -> function x -> function y -> function z -> f(x,y,z);;

let uncurry3 f (x, y, z) = f x y z;;

let uncurry3_ = function f -> function (x,y,z) -> f x y z;;
   

let f1 a b c = a+b+c;;
let f2 (a,b,c) = a+.b+.c;;

uncurry3 f1 (1,2,3) = 6;;
uncurry3_ f1 (1,2,3) = 6;;

curry3 f2 1. 2. 3. = 6.;;
curry3_ f2 1. 2. 3. = 6.;;

(*Zadanie 3*) 

let sumProd xs =
  List.fold_left (fun sum x ->
      let (a,b) = sum
      in
      (a+x,b*x)) (0,1) xs ;;

sumProd [1;2;3;4;5;6] = (21,720);;
sumProd [3;3;3] = (9,27);;
sumProd [] = (0,1);;

(*Zadanie 5*)

let insertionsort order xs = 
    let rec insert elem newList =
        match newList with 
            [] -> [elem]
          | h::t -> if order h elem then  h :: insert elem t
                       else elem :: newList
          
      
    in
    List.fold_left (fun acc newElement -> insert newElement acc) [] xs            
  
;;

let myOrder a b = 
  fst a <= fst b;;

insertionsort myOrder [(1,1);(3,1);(2,1);(8,1);(4,1);(6,1)] = [(1, 1); (2, 1); (3, 1); (4, 1); (6, 1); (8, 1)];;

insertionsort myOrder [(1,1);(3,1);(2,1);(8,1);(3,2);(3,3)] = [(1, 1); (2, 1); (3, 1); (3, 2); (3, 3); (8, 1)];;

let rec mergesort order xs =
  let rec merge xs1 xs2 =
    match (xs1,xs2) with
      ([],xs2) -> xs2
    | (xs1,[]) -> xs1
    | (h1::t1,h2::t2) -> if order h1 h2 then h1 :: merge t1 xs2
                         else h2 :: merge xs1 t2
                       
  and split leftSublist rightSublist counter =
    if counter = 0 then (List.rev leftSublist, rightSublist)
    else split (List.hd rightSublist :: leftSublist) (List.tl rightSublist) (counter - 1)
  in
  
  let partition = List.length xs /2 in
  
  if partition = 0 then xs
  else let (left,right) = split [] xs partition in
       merge (mergesort order left) (mergesort order right)
;;

mergesort myOrder [(1,1);(3,1);(2,1);(8,1);(4,1);(6,1)] = [(1, 1); (2, 1); (3, 1); (4, 1); (6, 1); (8, 1)];;

mergesort myOrder [(1,1);(3,1);(2,1);(8,1);(3,2);(3,3)] = [(1, 1); (2, 1); (3, 1); (3, 2); (3, 3); (8, 1)];;
    
  
