ocamlc -c CyclicArrayQueue.mli 
ocamlc -c CyclicArrayQueue.ml
ocamlc -c ArrayTest.ml
ocamlc -o ArrayTest CyclicArrayQueue.cmo ArrayTest.cmo
ocamlrun ArrayTest
