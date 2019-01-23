package homework;

/*Написать код выводящий число 153.5 в денежном виде для Украины.*/

import java.text.NumberFormat;
import java.util.Locale;

public class Task20_4 {
    public static void main(String[] args) {
        Locale loc = new Locale("uk", "UA");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(loc);
        System.out.println(loc.getDisplayName());
        System.out.println(currencyFormat.format(153.5));
    }
}
