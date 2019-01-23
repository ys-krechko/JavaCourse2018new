package homework.task03_5;

/*
Имеется целое число (любое), это число - сумма денег в рублях. Вывести это число,
добавив к нему слово "рублей" в правильном падеже.
*/

public class Task03_5Main {
    public static void main(String[] args) {
        int money=333;
        Task03_5Function function = new Task03_5Function();
        System.out.println(money+function.GetCase(money));
    }
}
