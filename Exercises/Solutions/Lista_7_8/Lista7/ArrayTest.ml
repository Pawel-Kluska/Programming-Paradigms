(*Pawel Kluska*)
(*Plik testujacy*)

let menu (opt) =
  let numItems = Array.length opt-1
  in
    begin
      print_string "\n\n=================================================== \n";
      print_string opt.(0);print_newline();
      for i=1 to numItems do  print_int i; print_string (". "^opt.(i)); print_newline() done;
      print_string "\nSelect an option: ";
      flush stdout;
      let choice = ref (read_int())
      in 
	while !choice < 1 || !choice > numItems do 
	  print_string ("Choose number between 1 and " ^ string_of_int numItems ^ ": ");
	  choice := read_int();
	done; 
	!choice
    end
;;

let s = ref (CyclicArrayQueue.empty 5);;
let menuItems = Array.make 7 "";;
let quit = ref false;;
let choice = ref 7;;

menuItems.(0) <- "CyclicArrayQueue Operations (implementation on mutable array)";
menuItems.(1) <- "enqueue";
menuItems.(2) <- "first";
menuItems.(3) <- "dequeue";
menuItems.(4) <- "isEmpty";
menuItems.(5) <- "isFull";
menuItems.(6) <- "quit testing";

while not !quit do
  begin
    choice := menu(menuItems);
    match !choice with
	1 ->
	  begin
	    print_string "Queue item = ";
            try CyclicArrayQueue.enqueue (read_int(), !s) with
              CyclicArrayQueue.Full m -> print_string ("Exception: "^m);
	  end  
      | 2 ->
	  begin
	    begin
	      try print_int (CyclicArrayQueue.first !s)  with 
		CyclicArrayQueue.Empty m -> print_string ("Exception: "^m);
	    end;
	    print_newline();
	  end
      | 3 ->
	 begin
	   CyclicArrayQueue.dequeue !s;
           print_string "dequeued\n"
           
	   
	  end
      | 4 ->
	    print_string ("Queue is "^(if CyclicArrayQueue.isEmpty !s then "" else "not ")^"empty.\n");

      | 5 ->
	    print_string ("Queue is "^(if CyclicArrayQueue.isFull !s then "" else "not ")^"Full.\n");

      | 6 ->
	    quit := true
      | _ ->
	    print_string "IMPOSSIBLE!!!\n"
  end
done
