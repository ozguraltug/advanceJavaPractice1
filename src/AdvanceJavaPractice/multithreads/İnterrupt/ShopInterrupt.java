package AdvanceJavaPractice.multithreads.İnterrupt;

import AdvanceJavaPractice.multithreads.waitNotify.ShopWaitNotify;

/*
Bir marketteki stock miktarınıtakip eden bir uygulama tasarlayınız.
Markette yeterki ürün yoksa yeni ürün gelmesini beklesin.
Yeni ürün eklenince ürün satışı gerçekleşsin.
 */
public class ShopInterrupt {
    //public static int stock = 0;  sonradan volatile ekledik
    public static volatile int stock = 1;

    public static void main(String[] args) {
        //bu bölümü if bloğu ve methodlar bittikten sonra yaz

        ShopInterrupt shop=new ShopInterrupt();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.consumeProduct(3);
            }
        });

        consumerThread.setName("Tüketici");
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // sleep i sonradan ekle
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.produceProduct(3);
                consumerThread.interrupt();
            }
        });
        producerThread.setName("Üretici");

        consumerThread.start();
        producerThread.start();

    }

    public synchronized void consumeProduct(int amount) {
        if (amount > stock) {
            //sonra ilk if bloğunu yaz
            System.out.println();
            System.out.println(Thread.currentThread().getName() + " ürün satın almak istiyor.");
            System.out.println("Yeterli ürün yok, Güncel ürün stoğu : " + stock);
            System.out.println("Tüketici ürün giriş yapılmasını bekliyor...");

            try {
                wait();
            } catch (InterruptedException e) {
                //önce burayı yaz
                if (amount <= stock) {
                    System.out.println();
                    System.out.println(Thread.currentThread().getName() + " ürün satın almak istiyor.");
                    System.out.println("Ürün satın alındı ve stocktan düşülüyor. ");
                    stock = stock - amount;
                    System.out.println("Güncel stok : " + stock);
                }
                //else yi en son yaz
                else {
                    System.out.println(Thread.currentThread().getName() + " ürün satın almak istiyor.");
                    System.out.println("Yeterli ürün yok, Güncel ürün stoğu : " + stock);
                    System.out.println("Bugün git yarın gel:)");
                }
            }
        }


    }

    public synchronized void produceProduct(int amount) {
        System.out.println();
        System.out.println(Thread.currentThread().getName() + " ürün eklemek istiyor.");
        System.out.println("Yeni ürünler eklendi, stok güncelleniyor...");
        stock = stock + amount;
        System.out.println("Güncel stok : " + stock);
        notify();
        System.out.println();
    }

}
