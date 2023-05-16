package AdvanceJavaPractice.multithreads.creation;

public class ThreadCreation3 {
    public static void main(String[] args) {

        //Task: anonymous class kullanarak thread oluşturunuz.


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Jerry");
                String name=Thread.currentThread().getName();
                for(int i=1;i<=100;i++){
                    System.out.println(name+" kaçıyorum");
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Tom");
                String name=Thread.currentThread().getName();
                for(int i=1;i<=100;i++){
                    System.out.println(name+" yakalıyorum");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
