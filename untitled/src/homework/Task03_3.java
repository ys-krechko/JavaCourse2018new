package homework;

/*Создайте число. Определите, является ли последняя цифра числа семёркой.*/

public class Task03_3 {

    public static void main(String[] args) {
        int x =27;
        if(x%10==7)
            System.out.println("Последняя цифра 7");
        else
            System.out.println("Последняя цифра не 7");
    }
}
