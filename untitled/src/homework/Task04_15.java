package homework;

/*Определить сумму элементов массива, расположенных между минимальным и максимальным значениями.*/

public class Task04_15 {
    public static void main(String[] args) {
        int[] array = {3, 8, 0, 1, 10, 4, 15};
        int min = array[0];
        int y = 0;
        int max = array[0];
        int x = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                x = i;
            }
            if (min > array[i]) {
                min = array[i];
                y = i;
            }
        }
        if (y < x) {
            for (int i = y + 1; i < x; i++) {
                sum += array[i];
            }
        } else if (x < y) {
            for (int i = x + 1; i < y; i++) {
                sum += array[i];
            }
        }
        System.out.println("Максимальное значение: " + max + ". Минимальное значение: " + min + ". Сумма элементов массива между макс. и мин. значениями: " + sum);
    }
}
