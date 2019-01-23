package homework;

/*Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
Найти самую высокую оценку с использованием итератора.*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Task11_28 {
    public static void main(String[] args) {
        int x = 10;
        Random r = new Random();
        List<Integer> marks = new ArrayList<>(x);
        for (int i = 0; i < x; i++) { // заполняет случайными числами
            marks.add(r.nextInt(11));
        }
        System.out.print(marks + " ");
        System.out.println();
        ListIterator<Integer> listIterator = marks.listIterator();
        int z = listIterator.next();
        int c = listIterator.next();
        int d = z;
        while (listIterator.hasNext()) { // поиск максимальной оценки
            if (z < c && d < c) {
                d = c;
            }
            z = c;
            c = listIterator.next();
            if (listIterator.hasNext() == false) { // проверка является ли последний элемент в коллекции максимальным
                if (z < c && d < c) {
                    d = c;
                }
            }
        }
        System.out.println("Максимальная оценка: "+d);
    }
}
