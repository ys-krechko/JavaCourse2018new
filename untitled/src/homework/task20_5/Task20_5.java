package homework.task20_5;

/*Создать программу, которая может приветствовать пользователя на трех языках: английском, русском,
белорусском. Требуемый язык и страна должны сообщаться программе в качестве входных параметров.
Если входные параметры отсутствуют, программа должна выдавать сообщение на английском.*/

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Task20_5 {
    public static void main(String[] args) {
        String language = "";
        String country = "";
        System.out.println("1 - Английский");
        System.out.println("2 - Русский");
        System.out.println("3 - Белорусский");
        System.out.println("Другое - Английский");
        char i = '2';
        switch (i) {
            case '1':
                language = "en";
                country = "GB";
                break;
            case '2':
                language = "ru";
                country = "RU";
                break;
            case '3':
                language = "be";
                country = "BY";
                break;
            default:
                language = "en";
                country = "GB";
                break;
        }
        Locale loc = new Locale(language, country);
        System.out.println(loc.getDisplayName());
        ResourceBundle rb = ResourceBundle.getBundle("homework.task20_5.text", loc);
        try {
            String st = rb.getString("greetings");
            String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(s1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
