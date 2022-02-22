let (+=) l r =
  if( Array.length l) = (Array.length r) then
    let n = ref 0
    in begin
        while !n < (Array.length l) do
          l.(!n)<- l.(!n) + r.(!n);
          n := !n + 1;
        done;
      end
  else invalid_arg "Tablice nie sa rowne"
;;

let t1 = [| 1; 2; 3; 5 |];;
let t2 = [| 3; 2; 1; 1 |];;
let t3 = [| 2; 5; 9; 7; 4|];;

t1 += t2;;
t1;;

t2+=t3;;

