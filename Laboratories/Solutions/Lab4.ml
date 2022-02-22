type 'a bt3 = Empty | Node of 'a * 'a bt3 * 'a bt3 * 'a bt3;;

let rec mapTree3 f t =
  match t with 
    Empty -> Empty
  | Node(e,l,m,r) -> Node(f e, mapTree3 f l , mapTree3 f m , mapTree3 f r)

;;

let t1 = Node(1,Node(2,Node(4,Empty,Empty,Empty),Node(7,Empty,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty,Empty),Node(2,Empty,Empty,Empty)),Empty,Empty),Node(3,Empty,Empty,Empty));;

let t2 = Node("aa",Node("b",Node("c",Empty,Empty,Empty),Node("e",Empty,Empty,Empty),Empty),Node("ok",Node("oi",Empty,Node("u",Empty,Empty,Empty),Node("h",Empty,Empty,Empty)),Empty,Empty),Node("d",Empty,Empty,Empty));;

let f1 a = a+5;;
let f2 a = a^".";;

mapTree3 f1 t1;;
mapTree3 f2 t2;;
mapTree3 f1 Empty;;


type word = Word of string;;
type sentence = Constative of word list | Exclamatory of word list | Question of word list;;
type text = Text of sentence list;;


