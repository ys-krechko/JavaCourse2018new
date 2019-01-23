package homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
с помощью регулярных выражений и вывести их на страницу.*/

public class Task19_2 {
    public static void main(String[] args) {
        String st = "jasdfh7670xFc24AB92, 5ad4a30X125EDc3/0Xx5de13";
        Pattern p = Pattern.compile("0[xX][\\da-fA-F]+");
        Matcher m = p.matcher(st);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
