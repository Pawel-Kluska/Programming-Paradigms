package lista11;

//Zadanie 2b

import java.util.concurrent.Semaphore;

class IntCell2b {
    private int n = 0;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}

class Count2b extends Thread {
    private static IntCell2b n = new IntCell2b();
    private static Semaphore semaphore = new Semaphore(1);


    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            temp = n.getN();
            n.setN(temp + 1);

            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Count2b p = new Count2b();
        Count2b q = new Count2b();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }
}
