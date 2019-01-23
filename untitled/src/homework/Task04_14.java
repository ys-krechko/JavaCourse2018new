package homework;

/*
Найти максимальный элемент массива, вывести не сам элемент, а его номер.
*/

public class Task04_14 {
    public static void main(String[] args) {
        int[] array = {1, 7, 6, 0, 12, 3, 5, 20};
        int max = array[0];
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                x = i;
            }
        }
        System.out.println("Номер максимального элемента: " + x);
    }
}
