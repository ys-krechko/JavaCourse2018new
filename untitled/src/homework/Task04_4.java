package homework;

/*
Имеется введенное число, найти сумму всех чисел до этого числа начиная с 0.
*/

public class Task04_4 {
    public static void main(String[] args) {
        int x = 11;
        int sum = 0;
        int array[] = new int[x];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            if (array[i] != 0) {
                sum += array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Сумма: " + sum);
    }
}
