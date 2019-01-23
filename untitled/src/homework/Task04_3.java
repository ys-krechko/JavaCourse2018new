package homework;

/*Введено число - вывести сумму всех его чисел*/

public class Task04_3 {
    public static void main (String[] args){
        int x=4565;
        int v=0;
        while (x!=0)
        {
            v +=x%10;
            x/=10;
        }
        System.out.print(v);
    }
}
