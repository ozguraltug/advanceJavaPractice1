package AdvanceJavaPractice.serialization;

import java.io.*;

//Task:Book tipinde nesneler üretip bu nesneleri
//books.txt dosyasına kaydedin ve sonra bu dosyadan
//nesneleri okuyun
public class SerializationPractice {
    public static void main(String[] args) {

      //  writeObject();
        readObcect();

    }

    public static void writeObject() {
        Book book1 = new Book("Sefiller", "Victor Hugo", 1980);
        Book book2 = new Book("Suç ve Ceza", "Dostoyevski", 1981);
        Book book3 = new Book("Savaş ve Barış", "Tolstoy", 1970);


        //dosyaları akışa almak yazdırmak için oluşturyoruz
        try {
            FileOutputStream fos = new FileOutputStream("books.txt");
            //nesneleri yazdırmak için
            ObjectOutputStream write = new ObjectOutputStream(fos);
            write.writeObject(book1);
            write.writeObject(book2);
            write.writeObject(book3);

            write.close();
            fos.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public static void readObcect() {

        //nesneleri okur
        try {
            FileInputStream fis = new FileInputStream("books.txt");

            //nesneleri anlayabileceği formata dönüştürmek için
            ObjectInputStream read = new ObjectInputStream(fis);

            Book book1 = (Book) read.readObject();
            Book book2 = (Book) read.readObject();
            Book book3 = (Book) read.readObject();

            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);

            read.close();
            fis.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
