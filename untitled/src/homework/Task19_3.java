package homework;

/*Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть
параметры, например <p id="p1">, и замену их на простые теги абзацев <p>.*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task19_3 {
    public static void main(String[] args) {
        String st = "<p> jasd<p>fh767, <p id=\"p1\"> 5ad4a30X12<p id=\"p3\">5EDc3/ <p> 0Xx ,<p>, 5de13 <p ln=\"p5\"><p id=\"p4\">";
        System.out.println(st);
        String stNew = st.replaceAll("<p [\\W\\w]+?>", "<p>");
        System.out.println(stNew);
        Pattern p = Pattern.compile("<p>");
        Matcher m = p.matcher(stNew);
        while (m.find()) {
            System.out.print(m.group()+" ");
        }
    }
}
