package homework;

/*
Имеется прямоугольное отверстием размерами a и b, определить, можно ли его полностью
закрыть круглой картонкой радиусом r.
*/

public class Task03_4 {

    public static void main(String[] args) {
        double a = 9;
        double b = 9;
        double r = 6.5;
        if (2*r>= Math.sqrt(a * a + b * b)) {
            System.out.println("Закроет полностью");
        } else {
            System.out.println("Не закроет полностью");
        }

    }
}

