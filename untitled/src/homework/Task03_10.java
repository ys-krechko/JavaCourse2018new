package homework;

/*
Имеется целое число. Следует посчитать сумму цифр данного числа.
*/

public class Task03_10 {
    public static void main(String[] args) {
        int x=9385;
        int v=0;
        while (x!=0)
        {
            v +=x%10;
            x/=10;
        }
        System.out.print(v);
    }
}
