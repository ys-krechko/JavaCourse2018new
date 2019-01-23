package homework;

/*
Имеется строка с текстом. Подсчитать количество слов в тексте.
Желательно учесть, что слова могут разделяться несколькими проблелами,
в начале и конце текста также могут быть пробелы, но могут и отсутствовать.
*/

public class Task06_19 {
    public static void main(String[] args) {
        String text = " Один два  три  четыре     пять   шесть     ";
        int count = text.trim().split(" +").length;
        System.out.println("Количество слов в предложении: " + count);
    }
}
