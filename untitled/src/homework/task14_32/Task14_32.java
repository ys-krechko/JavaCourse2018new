package homework.task14_32;

/*Записать в двоичный файл 20 случайных чисел. Прочитать записанный файл, распечатать числа
и их среднее арифметическое.*/

import java.io.*;
import java.util.Random;

public class Task14_32 {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        // записываем случайные числа в файл
        try (DataOutputStream dataOutput = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task14_32\\task14_32.txt")))) {
            int x;
            for (int i = 0; i < 20; i++) {
                dataOutput.writeInt(x=r.nextInt(100)-20);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }
        // читаем записанный файл
        DataInputStream dataInput = null;
        try {
            dataInput = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task14_32\\task14_32.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }
        int res = dataInput.readInt();
        int sum = 0;
        int count = 0;
        while (true) {
            System.out.print(res+" ");
            sum += res;
            count++;
            try {
                res = dataInput.readInt();
            } catch (EOFException e) {
                break;
            }
        }
        // высчитываем среднее арифметическое
        int average = sum / count;
        System.out.println("\nСумма чисел - " + sum + "\nКоличество чисел - " + count + "\nСреднее арифметическое - " + average);
        if (dataInput != null) {
            dataInput.close();
        }
    }
}
