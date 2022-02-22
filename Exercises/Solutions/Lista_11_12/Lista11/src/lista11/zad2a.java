package lista11;

//Zadanie 2a

class IntCell2a {
    private int n = 0;
    private boolean isChanged = true;


    public synchronized int getN() {
        while (!isChanged) {
            try { wait();} catch (InterruptedException e) {}
        }
        isChanged = false;
        notifyAll();;
        return n;
    }
    public synchronized void setN(int n) {
        while (isChanged) {
            try { wait();} catch (InterruptedException e) {}
        }
        this.n = n;
        isChanged = true;
        notifyAll();

    }
}

class Count2a extends Thread {
    private static IntCell2a n = new IntCell2a();

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            temp = n.getN();
            n.setN(temp + 1);

        }
    }
    public static void main(String[] args) {
        Count2a p = new Count2a();
        Count2a q = new Count2a();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }

}