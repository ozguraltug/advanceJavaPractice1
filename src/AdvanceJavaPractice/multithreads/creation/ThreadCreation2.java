package AdvanceJavaPractice.multithreads.creation;

//Task:Runnable interfacini implement eden Counter isminde sınıf oluşturup
//bu sınıftan harfleri a dan z ye kadar yazdıran iki tane thread oluşturun


//***************Bu task sonradan eklensin
//Task:Thread ler başlamadan önce yarış başladı yazsın,
//bitince de yarış bitti desin


public class ThreadCreation2 {
    public static void main(String[] args)  {

        System.out.println("Yarış Başladı");//Son eklenen taskle ekle

        Counter c1 = new Counter("Road runner");
        Counter c2 = new Counter("Speedy Gonzales");

        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//Önce bunu deneyelim
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Yarış bitti");//son eklenen taskle ekle
    }
}
