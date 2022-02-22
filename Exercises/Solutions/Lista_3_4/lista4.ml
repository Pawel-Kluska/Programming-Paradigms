(*Pawel Kluska*)

(*Przygotowanie drzew binarnych*)

type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let t1 = Node(1, Node(2, Node(4,Empty, Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty));;

let t2 =  Node(1,Node(2,Empty,Node(3,Empty,Empty)),Empty);;

(*Zadanie 2*)

let rec f x = f x;;


(*Zadanie 3*)

let breadth bt =
  let rec search nodeQueue =
    match nodeQueue with
      [] -> []
    | Empty :: t -> search t
    | Node(a,left,right) :: t -> a :: search (t@[left;right])
  in
  search [bt]
;;

breadth t1 = [1; 2; 3; 4; 5; 6];;
breadth t2 = [1;2;3];;

(*Zadanie 4*)

let internalPath bt =
  let rec search b depth =
    match b with
      Empty -> 0
    | Node(_,left,right) -> depth + search left (depth+1) + search right (depth+1)
  in
  search bt 0
;;

internalPath t1 = 9;;
internalPath t2 = 3;;


let externalPath bt =
  let rec search b depth =
    match b with
      Empty -> depth
    | Node(_,left,right) -> search left (depth+1) + search right (depth+1)
  in
  search bt 0
;;

externalPath t1 = 21;;
externalPath t2 = 9 ;;

(*Przygotowanie grafow*)

type 'a graph = Graph of ('a -> 'a list);;

let g = Graph(function
              0 -> [3]
            | 1 -> [0;2;4]
            | 2 -> [1]
            | 3 -> []
            | 4 -> [0;2]
            | n -> failwith ("Graph g: node "^string_of_int n^" doesn't exist")
          );;

let Graph succ = g;;
succ 1;;

(*Zadanie 5*)

let depthSearch (Graph succ) startNode =
  let rec search queue visited =
    match queue with
      [] -> []
     |h::t -> if List.mem h visited then search t visited
              else h::search((succ h) @ t)(h::visited)
  in
  search [startNode] []
;;

depthSearch g 2 = [2; 1; 0; 3; 4];;
depthSearch g 4 = [4; 0; 3; 2; 1];;

