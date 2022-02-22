let rec find = fun xs x ->
   match xs with 
    (h :: t) when h = x -> true
   |(h :: t) when h <> x -> find t x
   | [] -> false
;;
                           
                          
                                         

find [1;2;3;4] 0 ;;

let find123 x = find [1.;2.;3.] x ;;
find123 2.;;
find123 8.;;

let split2Rec xs = 
  let rec split2Rec2 (xs, l) = 
     match (xs, l) with 

       ([],_) -> ([], [])

       |(h::t,1) -> let (a,b) = split2Rec2(t,0) in (h::a,b)

       |(h::t,0) -> let (a,b) = split2Rec2(t,1) in (a,h::b)
    
 in split2Rec2(xs,1)
;;
split2Rec [1;2;3;4;5;6];;


let split2Tail xs2 = 
  let rec split2Tail2 (xs2,w,l) = 
      match (xs2, w, l) with 

       ([],_, _) -> w

       |(h::t,(a,b),1) -> split2Tail2(t,(h::a, b),0)

       |(h::t,(a,b),0) -> split2Tail2(t,(a, h::b),1)

       
    
 in split2Tail2(xs2,([],[]),1)
  
;;

split2Tail [1;2;3;4;5;6];;
