package homework;

/*Имеется промежуток времени в секундах. Следует вывести его в виде недель, суток, часов, минут, секунд.*/

public class Task03_2 {
    public static void main(String[] args) {
        int s = 913700;
        int sec;
        int m;
        int min;
        int h;
        int hour;
        int d;
        int day;
        int w;
        sec = s % 60;
        m = s / 60;
        min = m % 60;
        h = m / 60;
        hour = h % 24;
        d = h / 24;
        day = d % 7;
        w = d / 7;
        System.out.println(w + "недель" + day + "дней" + hour + "часов" + min + "минут" + sec + "секунд");
    }
}
