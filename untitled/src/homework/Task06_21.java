package homework;

/*Напишите два цикла выполняющих многократное сложение строк, один с помощью оператора сложения и String,
а другой с помощью StringBuilder и метода append. Сравните скорость их выполения.*/

public class Task06_21 {
    public static void main(String[] args) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        long begin = 0;
        long end = 0;

        begin = System.nanoTime(); // цикл String
        for (char i = 'a'; i < 'z'; i++) {
            str += i;
        }
        end = System.nanoTime();
        System.out.println("String: " + str);
        System.out.println("Скорость выполнения цикла String - " + (end - begin) + " наносекунд");

        begin = System.nanoTime(); // цикл StringBuilder
        for (char i = 'a'; i < 'z'; i++) {
            sb.append(i);
        }
        end = System.nanoTime();
        System.out.println("\nStringBuilder: " + sb);
        System.out.println("Скорость выполнения цикла StringBuilder - " + (end - begin) + " наносекунд");

    }
}
