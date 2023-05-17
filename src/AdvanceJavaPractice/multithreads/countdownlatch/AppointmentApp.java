package AdvanceJavaPractice.multithreads.countdownlatch;

import java.util.concurrent.CountDownLatch;

/*
Geri sayım tamalanıncaya kadar CountDownLatch örneğinin "await()" methodunu çağıran tüm threadler bekletilir.
Geri sayım tamamlandığında bir anlamda kapı sürgüsü açılır ve bekleyen threadler işlemeye devam eder.
Örneğin "n" sayıda threadin işlerini bitirdiklerini bildirene kadar (yani her biri sayacı bir azaltana ve
nihayetinde sayacın değeri sıfıra ulaşana kadar) ana threadin bekletilmesi istediğimiz bir
durumda kullanılabilir.

Task:Bir randevu oluşturma uygulaması tasarlayınız. (AppointmentCenter)
Uygulama herbir talep için bir gün sonrasını tarih vermelidir.
Randevu tarihini veren threadlerden önce randevu öncesinde
bazı işlemleri gerçekleştiren threadlerin çalışmasını sağlayınız.
 */
public class AppointmentApp {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        String[] users = {"Bill", "Steve", "Linus", "Tim", "Larry"};
        AppointmentCenter center=new AppointmentCenter();
        for(String user:users){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Randevu Tarihiniz : "+center.getAppointmentDate());
                }
            });
            thread.start();
        }
        Worker worker1=new Worker("A",countDownLatch);
        Worker worker2=new Worker("B",countDownLatch);
        Worker worker3=new Worker("C",countDownLatch);

        worker1.start();
        worker2.start();
        worker3.start();


    }


}
