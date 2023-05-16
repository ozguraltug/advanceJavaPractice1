package AdvanceJavaPractice.generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        String[] stdList = {"Rafeel", "Donatello", "Leonardo", "MichelAngelo"};
        Double[] pointList = {75.5, 80.0, 90.75, 81.0};
        Character[] gradeList = {'A', 'B', 'C', 'D'};

        //1.Tüm listeleri yazdır
        printArray(stdList);
        printArray(pointList);
        printArray(gradeList);
        //2.Öğrencileri isimlerine göre sıralayınız
        System.out.println(Arrays.toString(orderArr(stdList)));
        System.out.println("");


        //3.Öğrenci notlarını sıralayınız

        System.out.println(Arrays.toString(orderArr(pointList)));
        System.out.println("");

        //4.Öğrenci harf notlarını sıralayınız

        System.out.println(Arrays.toString(orderArr(gradeList)));
    }

    //5.Diziyi yazdıran bir method yazınız
    public static <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    //6.Diziyi artan sıralayan bir method yazınız
    public static <T extends Comparable<T>> T[] orderArr(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;

    }

}
