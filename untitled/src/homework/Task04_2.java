package homework;

/*
Имеется последовательность случайных чисел, найти и вывести наибольшее из них.
*/

import java.util.Random;

public class Task04_2 {
    public static void main (String [] args){
        Random r=new Random();
        int array[] = new int [10];
        for(int i=0; i<array.length; i++){ // заполняем массив случайными числами
            array[i]=r.nextInt(201) - 100;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int max=array[0]; // ищем максимальное из них
        for(int i=1; i<array.length; i++){
            if (max<array[i]){
                max=array[i];
            }
        }
        System.out.print(max);
    }
}
