package AdvanceJavaPractice.multithreads.synchronization;
//Multithreading programlamada birden fazla Thread aynı anda ortak bir kaynağa erişmeye çalışırsa
//istenmeyen sonuçlar oluşacaktır. Bu durumda threadlere sırayla erişim vermek gerekecektir.
//Bir thread kaynağı kullanırken diğerleri onu beklemelidirler. Bu "synchronized" keywordu ile sağlanır.


public class AppointmentApp {
    public static void main(String[] args) {

        String[] users = {"Bill", "Steve", "Linus", "Tim", "Larry"};
        AppointmentCenter appointmentCenter = new AppointmentCenter();
for(String user:users) {
    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            //Thread.currentThread().setName(users[0]); önce böyle çalıştırılacak sonra değiştirdik
            Thread.currentThread().setName(user);
            String name = Thread.currentThread().getName(); //getname yazmazska thread0 gibi isimler verir
            System.out.printf("Sayın %-8s, Randevu tarihiniz : %10s %n",name, appointmentCenter.getAppointmentDate());
        }
    });
    thread.start();
}
    }
}
