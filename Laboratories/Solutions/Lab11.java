package package1;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Kurnik {

    protected Random generator;
    protected Grzeda[] kurnik;

    public Kurnik() {
        kurnik = new Grzeda[5];
        generator = new Random();

        for(int i=0; i< kurnik.length; i++){
            kurnik[i] = new Grzeda();
        }

    }

    public void zniesJajko(){
        int wylosowanaGrzeda = generator.nextInt(kurnik.length);
        kurnik[wylosowanaGrzeda].dodajJajko();
    }

    public void zbierzJajka(){
        for(int i=0; i< kurnik.length; i++){
            kurnik[i].setIloscJajek(0);
        }
        System.out.println("Gospodzarz zebral jajka");
    }
}

class KurnikMonitory extends Kurnik{
    private boolean ktoreZajete[];
    private boolean czyKtorasZajeta;

    public KurnikMonitory() {
        super();
        ktoreZajete = new boolean[kurnik.length];

        for(int i=0; i< ktoreZajete.length; i++){
            ktoreZajete[i] = false;
        }

        czyKtorasZajeta = false;
    }
    @Override
    public synchronized void zniesJajko(){
        int wylosowanaGrzeda = generator.nextInt(kurnik.length);

        while (ktoreZajete[wylosowanaGrzeda] == true) {
            try {
                System.out.println(Thread.currentThread().getName() + " czeka na grzede");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        ktoreZajete[wylosowanaGrzeda] = true;
        czyKtorasZajeta = true;
        kurnik[wylosowanaGrzeda].dodajJajko();
        ktoreZajete[wylosowanaGrzeda] = false;
        czyKtorasZajeta = false;
        notifyAll();
    }

    @Override
    public synchronized void zbierzJajka(){
        while (czyKtorasZajeta == true)
            try {
                System.out.println(Thread.currentThread().getName() + " czeka na zabranie jajek");
                wait();
            }
            catch (InterruptedException e) {System.out.println(e);}

        czyKtorasZajeta = true;
        System.out.println(Thread.currentThread().getName() + " oproznia kurnik");
        for(int i=0; i< kurnik.length; i++){
            ktoreZajete[i] = true;
            kurnik[i].setIloscJajek(0);
            ktoreZajete[i] = false;
        }

        czyKtorasZajeta = false;
        notifyAll();
    }
}

class KurnikSemafory extends Kurnik {

    private static Semaphore[] ktoreZajete;
    private static Semaphore czyKtorasZajeta;

    public KurnikSemafory() {
        super();
        ktoreZajete = new Semaphore[kurnik.length];

        for(int i=0; i< ktoreZajete.length; i++){
            ktoreZajete[i] = new Semaphore(1);;
        }

        czyKtorasZajeta = new Semaphore(1);
    }
    @Override
    public void zniesJajko(){
        int wylosowanaGrzeda = generator.nextInt(kurnik.length);

        try {
            ktoreZajete[wylosowanaGrzeda].acquire();
            czyKtorasZajeta.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        kurnik[wylosowanaGrzeda].dodajJajko();

        ktoreZajete[wylosowanaGrzeda].release();
        czyKtorasZajeta.release();
    }

    @Override
    public void zbierzJajka(){

        try{
            czyKtorasZajeta.acquire();
            System.out.println(Thread.currentThread().getName() + " oproznia kurnik");
            for(int i=0; i< kurnik.length; i++) {
                ktoreZajete[i].acquire();
                kurnik[i].setIloscJajek(0);
                ktoreZajete[i].release();
            }
        }catch (InterruptedException e) {System.out.println(e);}
        czyKtorasZajeta.release();
    }
}


class Kura extends Thread{

    private Random generator;
    private Kurnik kurnik;

    public Kura(String nazwa, Kurnik kurnik){
        super(nazwa);
        this.generator = new Random();
        this.kurnik = kurnik;
    }

    public void pobiegaj(){
        try {
            System.out.println(Thread.currentThread().getName() + " biega");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){

        for(int i=0; i<10; i++){
            kurnik.zniesJajko();
            pobiegaj();
        }
    }
}

class Gospodarz extends Thread{

    private Random generator;
    private Kurnik kurnik;

    public Gospodarz(String nazwa, Kurnik kurnik){
        super(nazwa);
        this.generator = new Random();
        this.kurnik = kurnik;
    }


    @Override
    public void run(){
        for(int i=0; i<2; i++){
            kurnik.zbierzJajka();
        }
    }
}

class Grzeda {

    protected int iloscJajek;
    protected Random generator;

    public Grzeda() {
        iloscJajek = 0;
        generator = new Random();
    }

    public void dodajJajko(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " Weszla na grzede");
            if (generator.nextDouble() < 0.5) {
                System.out.println(Thread.currentThread().getName() + " znosi jajko");
                iloscJajek++;
            }
            System.out.println(Thread.currentThread().getName() + " Zeszla z grzedy");
        }
    }

    public int getIloscJajek() {
        return iloscJajek;
    }

    public void setIloscJajek(int iloscJajek) {
        this.iloscJajek = iloscJajek;
    }
}

public class Main {

    public static void main(String[] args) {
        Kurnik kurnik = new Kurnik();
        Thread test1[] = new Kura[5];
        Thread gospodarz;

//        for(int j=0; j < 5; j++){
//            test1[j] = new Kura(("Kura " + j), kurnik);
//        }
//        gospodarz = new Gospodarz("Gospodarz ", kurnik);
//        gospodarz.start();
//        for(Thread t: test1) { t.start(); }

//        kurnik = new KurnikMonitory();
//        test1 = new Kura[5];
//
//
//        for(int j=0; j < 5; j++){
//            test1[j] = new Kura(("Kura " + j), kurnik);
//        }
//        gospodarz = new Gospodarz("Gospodarz ", kurnik);
//        gospodarz.start();
//        for(Thread t: test1) { t.start(); }
//
//
        kurnik = new KurnikSemafory();
        test1 = new Kura[5];

        for(int j=0; j < 5; j++){
            test1[j] = new Kura(("Kura " + j), kurnik);
        }
        gospodarz = new Gospodarz("Gospodarz ", kurnik);
       // gospodarz.start();
        for(Thread t: test1) { t.start(); } // fork

    }
}
