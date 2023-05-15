package AdvanceJavaPractice.multithreads.volatileKewword;

public class Numarator {

    // private static int counter = 0; önce böyle hatadan sonra düzeltilecek

    private volatile static int counter = 0;
    //volatile ile counter sayısı rame kaydoluyor
    //ancak tüm threadlerin değişkene aynı anda ulaşmasından kaynaklı çakışmayı çzömeyi garanti etmez
    //bunun içinde synchronized keywordu ekledik


    //  public void getOrder() { önce method böyleydi sonra synchronized ekledik
    public synchronized void getOrder() {
        String name = Thread.currentThread().getName();
        counter++;
        System.out.println("Sayın " + name + " sıranız: " + counter);
    }
}
