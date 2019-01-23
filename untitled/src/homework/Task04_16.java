package homework;

/*
Создать массив, заполнить его случайными элементами, распечатать, перевернуть, и снова распечатать
(при переворачивании нежелательно создавать ещё один массив).
*/

import java.util.Random;

public class Task04_16 {
    public static void main(String[] args) {
        int x = 10;
        int[] array = new int[x];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(201) - 100;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
