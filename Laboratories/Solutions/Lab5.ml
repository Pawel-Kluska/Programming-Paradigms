type 'a stol = Los of (unit -> 'a) | Odkryty of 'a;;


let rec makeList list =
  match list with
    [] -> []
  | h::t -> Los(fun()->h) :: makeList t;;

let list = ["Laptop";"Komputer";"Smartfon";"Tablet";"Telewizor"];;

let list1 = makeList list;;

let rec buyTicket list n =
  match (list,n-1) with
    ([] ,_) -> []
  | (Los(h)::t,0) -> Odkryty(h()) :: buyTicket t (-1)
  | (Los(h)::t,_) -> Los(h) :: buyTicket t (n-1)
  | (Odkryty(h)::t,_) -> Odkryty(h) :: buyTicket t (n-1)
;;

let d = buyTicket list1 0;;
let a = buyTicket d 5;;
let b = buyTicket a 1;;
let c = buyTicket b 20;;




