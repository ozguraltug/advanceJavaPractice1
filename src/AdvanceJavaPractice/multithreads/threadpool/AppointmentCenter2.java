package AdvanceJavaPractice.multithreads.threadpool;

import java.time.LocalDate;

public class AppointmentCenter2 {

    private LocalDate day = LocalDate.now();

   // public LocalDate getAppointmentDate() önce böyle çalıştırılacak
    public synchronized LocalDate getAppointmentDate(){
        day = day.plusDays(1);  // Bir gün sonrasını veriri
        return day;
    }
}
