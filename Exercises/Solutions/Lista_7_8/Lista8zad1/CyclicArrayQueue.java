package main_package;

import java.util.ArrayList;

public class CyclicArrayQueue<E> implements MyQueue<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private ArrayList<E> array;
    private int f = 0;
    private int r = 0;

    @SuppressWarnings("unchecked")
    public CyclicArrayQueue(int size) {
        array = new ArrayList<>(size+1);

        for (int i = 0; i <= size; i++) {
            array.add(null);
        }

    }

    public CyclicArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void enqueue(E x) throws FullException {
        if(isFull())
            throw new FullException("CyclicArrayQueue: enqueue");
        array.set(r, x);
        r = (r + 1) % array.size();
    }

    @Override
    public void dequeue() {
        if(!isEmpty()) {
            f = (f + 1) % array.size();        }
    }

    public E first() throws EmptyException {
        if(isEmpty())
            throw new EmptyException("CyclicArrayQueue: first");
        return array.get(f);
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }
    @Override
    public boolean isFull() {
        return f == (r +1) % array.size();
    }
}
