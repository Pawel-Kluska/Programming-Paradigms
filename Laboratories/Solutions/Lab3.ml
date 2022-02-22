let revNCamp f n = fun x ->
  let rec revNCamp2 (f, n, x, l) =
    if n<0 then []
    else if n<=1 then l
    else revNCamp2 (f, (n-1), f(x), ((f x) :: l))
  in revNCamp2 (f, n, x, [x])
;;

let funct1 x = x*2;;
let funct2 x = x^"n";;
let funct3 x = x+.3.;;

revNCamp funct1 10 1;;
revNCamp funct2 8 "n";;
revNCamp funct3 8 1.;;



let area (a,b) f n =   
  let rec range (x,y) =
    if x = y then []
    else x :: range(x+.1.,y)
    and
      base =  ((b -. a) /. (float_of_int n)) 
  in
  
  base *. List.fold_left (fun acc i -> acc +. f(a +. i *. base +. base /. 2.) ) 0. (range (0.,float_of_int n))
  
;;

area (0.,10.)(fun c -> c*.c+.2.*.c+.1.)(10000);;
area (-10.,10.)(fun c -> c)(100);;
area (-10.,10.)(fun c -> 2.)(10000);;
           
