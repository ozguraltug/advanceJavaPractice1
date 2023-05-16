package AdvanceJavaPractice.multithreads.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Thread oluşturmak maliyetli bir olaydır.Her thread için sistemden belli bir kaynak ayırılır.
Bu kaynaklar CPU, Hafıza gibi önemli olanlardır. Uygulamamız çalışırken belli bir miktarda
thread ile sınırlamak isteyebiliriz.

Bu nedenle Thread havuzu oluşturup bu havuzu önceden oluşturulmuş ve kullanıma hazır Thread nesneleri
ile doldururuz. Böylece performans kazanımı ve sistem kaynaklarının verimli kullanımını sağlayabiliriz.

Task: Bir randevu oluşturma uygulaması tasarlayınız. (AppointmentCenter)
Uygulama herbir talep için bir gün sonrasını tarih vermelidir. 5 kişi için
randevu alınmak isteniyor. Thread havuzu oluşturup işleri 3 threade yaptırınız
 */
public class AppointmentApp2 {
    public static void main(String[] args) {

        // thread havuzu oluşturmak için
        ExecutorService service = Executors.newFixedThreadPool(3);

        String[] users = {"Bill", "Steve", "Linus", "Tim", "Larry"};

        AppointmentCenter2 appointmentCenter=new AppointmentCenter2();
        for(String user:users){
            MyThread thread=new MyThread(appointmentCenter);
            //burda thread başlatmıyorum sadece threadi havuza atıyorum
            service.execute(thread); //ihtiyaç olduğunda threadi oluşturup buraya bırakacak
        }
        service.shutdown();

    }

}

class MyThread extends Thread {
    private AppointmentCenter2 appointmentCenter;

    public MyThread(AppointmentCenter2 appointmentCenter) {
        this.appointmentCenter = appointmentCenter;
    }

    @Override
    public void run() {
        String tname = Thread.currentThread().getName();
        System.out.println("++"+tname+" başladı.");
        System.out.println("Randevu tarihiniz : "+appointmentCenter.getAppointmentDate());
        System.out.println(".."+tname+" bitti.");
    }
}