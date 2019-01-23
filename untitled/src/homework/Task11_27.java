package homework;

/*
Создать коллекцию, наполнить её случайными числами.
Удалить повторяющиеся числа.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task11_27 {
    public static void main(String[] args) {
        int x = 10;
        Random r = new Random();
        List<Integer> marks = new ArrayList<>(x);
        for (int i = 0; i < x; i++) { // заполняет случайными числами
            marks.add(r.nextInt(11));
        }
        System.out.print(marks + " ");
        System.out.println();
        int z=marks.get(0);
        for (int i = 1; i < x; i++) { // удаляет повторяющиеся числа
            for (int j = i; j < x; j++) {
                if (z == marks.get(j)) {
                    marks.remove(j);
                    j--;
                    x--;
                    if (i>1){
                    i--;}
                }
            }
            z=marks.get(i);
        }
        System.out.print(marks + " ");
    }
}
