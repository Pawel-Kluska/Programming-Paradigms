package main_package;

public class Main {

    public static void main(String[] args) throws EmptyException, FullException{
        MyQueue<Integer> queue = new CyclicArrayQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.first());
        queue.dequeue();
        queue.enqueue(4);
        System.out.println(queue.first());
        queue.dequeue();
        queue.enqueue(5);
        System.out.println(queue.first());

    }
}
