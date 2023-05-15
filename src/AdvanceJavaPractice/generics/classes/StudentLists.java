package AdvanceJavaPractice.generics.classes;

public class StudentLists {

//    Task 1:Java dersi için öğrencileri, isim, vize notu ve final notu ile birlikte listeleyen bbir program yazınız
//    Task 2.Kütüphane için öğrencileri isim, okul ve mail adresi ile birlikte listeleyen bir program yazınız

    public static void main(String[] args) {
        System.out.println("**** Java dersi vize ve final notları ****");
        listGrade();

        System.out.println("****Kütüphane Üye Listesi****");
        listMemberLibrary();
    }

    //öğrencilerin notlarını listeleyen bir method yzınız
    public static void listGrade() {
        Student<String, Double, Double> std1 = new Student<>
                ("Joe", 75.8, 90.0);
        Student<String, Double, Double> std2 = new Student<>
                ("Jack", 65.8, 80.0);
        Student<String, Double, Double> std3 = new Student<>
                ("Avarel", 45.8, 60.0);

        System.out.printf("%-12s || %.2f || %.2f \n",
                std1.getS(), std1.getU(), std1.getV());
        System.out.printf("%-12s || %.2f || %.2f \n",
                std2.getS(), std2.getU(), std2.getV());
        System.out.printf("%-12s || %.2f || %.2f \n",
                std3.getS(), std3.getU(), std3.getV());
    }


    //kütüphane üye öğrenci listesin, yazdıran bir method yazınız

    public static void listMemberLibrary() {
        Student<String, Integer, String> std1 =
                new Student<>("William", 500, "william@gmail.com");
        Student<String, Integer, String> std2 =
                new Student<>("Red Kit", 400, "redkit@gmail.com");
        Student<String, Integer, String> std3 =
                new Student<>("Rin Tin Tin", 300, "rintintin@gmail.com");

        System.out.printf("%-12s || %4d || %-20s \n",
                std1.getS(), std1.getU(), std1.getV());
        System.out.printf("%-12s || %4d || %-20s \n",
                std2.getS(), std2.getU(), std2.getV());
        System.out.printf("%-12s || %4d || %-20s \n",
                std3.getS(), std3.getU(), std3.getV());

    }
}
