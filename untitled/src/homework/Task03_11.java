package homework;

/*
Имеется целое число, определить является ли это число простым, т.е. делится без остатка только на 1 и себя.
*/

public class Task03_11 {
    public static void main(String[] args) {
        int n = 10;
        boolean simple = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                simple = false;
                break;
            }
        }
        if (simple) {
            System.out.println("Число простое");
        } else {
            System.out.println("Число составное");
        }
    }
}
