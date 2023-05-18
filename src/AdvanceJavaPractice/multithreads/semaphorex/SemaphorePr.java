package AdvanceJavaPractice.multithreads.semaphorex;

import java.util.concurrent.Semaphore;

/*
Semaphore bir kaynağa erişebilen iş parçacığını sayısını kısıtlamak için kullanılır.
Yani, sychronized sadece bir iş parçacığının kilitlenmesi ve
senkronize blok / yöntemi yürütmesine izin verirken, Semaphore n iş parçacığına izin verir
ve diğerlerini engeller.

senaryo:deneme kabini / deneme kasası
Mağazanın 3 deneme kabini var. 5 kişi mağazanın kabinini
kullanmak istiyor. Bu 5 tane işlem için 5 thread kullanılsın.
 */
public class SemaphorePr {
    public static void main(String[] args) {


        Semaphore semaphore = new Semaphore(3);
        Person person1 = new Person("Mark", semaphore);
        Person person2 = new Person("Jeff", semaphore);
        Person person3 = new Person("Elon", semaphore);
        Person person4 = new Person("Lovelace", semaphore);
        Person person5 = new Person("Sergey", semaphore);

        person1.start();
        person2.start();
        person3.start();
        person4.start();


    }
}

class Person extends Thread {
    private String name;
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(name + " kabine girmek istiyor...");
        try {
            semaphore.acquire(); //semaphore soruyoruz kabinler müsait mi try catche al
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " kabine girdi");
        System.out.println(name + " kabini kullanıyor.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " kabinden çıkıyor.."); //Anahtarı teslim etmeli
        semaphore.release();
    }
}