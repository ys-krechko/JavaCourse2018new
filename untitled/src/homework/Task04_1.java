package homework;

/*
Выполнить сортировку только четных элементов массива (нечетные элементы остаются на своих местах).
*/

public class Task04_1 {
    public static void main (String [] args) {
        int [] array = {3, 4, 1, 5, 8, 7, 2, 6, 9};
        for (int name:array){
            System.out.print(name+ " ");}
            System.out.println();
        for (int i=0; i<array.length; i++){
            int x=i;
            if (array[i]%2==0) {
                for (int j=i; j<array.length; j++){
                    if (array[j]%2==0){
                      if (array[x]>array[j]){
                          x=j;
                      }
                    }
                }
            int temp=array[x];
            array[x]=array[i];
            array[i]=temp;
            }
        }
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+ " ");}
    }
}
