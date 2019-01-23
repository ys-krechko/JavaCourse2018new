package homework.task14_30;

/*Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task14_30 {
    public static void main(String[] args) throws IOException {
        int countWords = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task14_30\\task14_30.txt"))) {
            String c;
            int lengthBefore = 0;
            int lengthAfter = 0;
            while ((c = reader.readLine()) != null) {
                System.out.println(c);
                countWords += c.replaceAll("[,.!?;:/'-]", " ").split("\\s+").length;
                lengthBefore += c.length();
                lengthAfter += c.replaceAll("[,.!?;:/'-]", "").length();
            }
            System.out.println("Количесвто слов - " + countWords);
            System.out.println("Количесвто слов - " + (lengthBefore - lengthAfter));
        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }
}
