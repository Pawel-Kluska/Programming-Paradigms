package lista11;

import java.util.Random;
import java.util.concurrent.Semaphore;

class DiningRoom {
    private static final int numberOfPhilosophers = 5;
    private static final Random random = new Random();
    private static final Semaphore doorman = new Semaphore(4);
    private static final Stick[] sticks = new Stick[5];

    public static void main(String[] args) {
        for (int i = 0; i < numberOfPhilosophers; i++)
            sticks[i] = new Stick();
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }
    }

    static class Philosopher extends Thread {
        private final Stick left, right;

        Philosopher(int number) {
            super("Philosopher" + number);
            right = sticks[number];
            left = sticks[(number + 1) % numberOfPhilosophers];
        }

        void meditate() throws InterruptedException {
            System.out.println(getName() + " is meditating");
            sleep(random.nextInt(10000));
            System.out.println(getName() + " has finished meditating");
        }

        void eat() throws InterruptedException {
            doorman.acquire();
            left.take();
            right.take();
            System.out.println(getName() + " is eating");
            sleep(random.nextInt(10000));
            left.release();
            right.release();
            doorman.release();
        }

        @Override
        public void run() {
            try {
                for(int i=0; i<10; i++){
                    meditate();
                    eat();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Stick {
        private final Semaphore available = new Semaphore(1);

        void take() throws InterruptedException {
            available.acquire();
        }

        void release() {
            available.release();
        }
    }
}
