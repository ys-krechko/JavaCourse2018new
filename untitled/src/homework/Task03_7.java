package homework;

/*
Имеются 2 дома размерами a на b и c на d. Имеется участок размерами e на f. Проверить помещаются ли эти дома на данном участке. Сторонны домов - параллельны сторонам участка, в остальном размещение может быть любым.
*/

public class Task03_7 {
    public static void main(String[] args) {
        int a = 8;
        int b = 5;
        int c = 7;
        int d = 6;
        int e = 8;
        int f = 10;
        if ((e >= a + c) && (f >= b && f >= d)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((e >= a + d) && (f >= b && f >= c)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((e >= b + c) && (f >= a && f >= d)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((e >= b + d) && (f >= a && f >= c)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((f >= a + d) && (e >= b && e >= c)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((f >= a + c) && (e >= b && e >= d)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((f >= b + d) && (e >= a && e >= c)) {
            System.out.println("Два дома помещаются на данном участке");
        } else if ((f >= b + c) && (e >= a && e >= d)) {
            System.out.println("Два дома помещаются на данном участке");
        } else {
            System.out.println("Два дома не помещаются на данном участке");
        }
    }
}
