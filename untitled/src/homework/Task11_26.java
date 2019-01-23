package homework;

/*
Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
Удалить неудовлетворительные оценки из списка.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Task11_26 {
    public static void main(String[] args) {
        int x = 10;
        Random r = new Random();
        List<Integer> marks = new ArrayList<>(x);
        for (int i = 0; i < x; i++) { // заполняет случайными оценками
            marks.add(r.nextInt(11));
        }
        System.out.print(marks + " ");
        System.out.println();
        // удаляет неудовлетворительные оценки из списка
        ListIterator<Integer> listIter = marks.listIterator();
        while (listIter.hasNext()) {
            if (listIter.next() <= 3) {
                listIter.remove();
            }
        }
        for (Integer m : marks) {
            System.out.print(m+" ");
        }
    }
}
