package homework;

/*
Имеется сумма чисел. Рассчитать их произведение (факториал числа).
*/

public class Task04_5 {
    public static void main(String[] args){
        int x =12;
        int fact=1;
        int array[]= new int [x];
        for(int i=0; i<array.length; i++){
            array[i]=i;
            if(array[i]!=0){
                fact *= array[i];
            }
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.print("Факториал числа: "+fact);
    }
}
