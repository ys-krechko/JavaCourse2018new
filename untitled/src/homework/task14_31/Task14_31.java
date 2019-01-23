package homework.task14_31;

/*Имеется файл с текстом в котором присутствуют числа.
Найти все числа, распечатать, посчитать сумму, убрать все повторяющиеся числа и снова распечатать.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task14_31 {

    public static void main(String[] args) throws IOException {
        String c;
        String x = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task14_31\\task14_31.txt"))) {
            while ((c = reader.readLine()) != null) { //читаем файл
                System.out.println(c);
                x = x.concat(c);
            }

            { //ищем цифры
                String[] array = (x.replaceAll("\\D+", " ").trim()).split(" ");
                Integer[] a = new Integer[array.length];
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    a[i] = Integer.valueOf(array[i]);
                    sum += a[i];
                    System.out.print(a[i] + " ");
                }
                System.out.println("\nСумма чисел - " + sum);

                { // удаляем повторяющиеся и распечатываем
                    List<Integer> listNumbers = new ArrayList(Arrays.asList(a));
                    System.out.println(listNumbers);
                    Set<Integer> uniqueNumbers = new LinkedHashSet<>(listNumbers);
                    System.out.println(uniqueNumbers);
                }

            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }


}
