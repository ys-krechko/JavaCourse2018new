package task30_13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;

public class DifferentMethods {
    private static String logFile = "This is log file. \n\n"; //заголовок для лог-файла
    Date date = new Date(); //дата для лог-файла
    DateFormat df = DateFormat.getDateTimeInstance();
    HashSet<String> cookiesHashSet = new HashSet<>(); //коллекция

    //перекодирование текста
    static public String encode(String src, String defpage, String codepage) {
        String answer = "";
        try {
            answer = new String(src.getBytes(defpage), codepage);
        } catch (Throwable e) {
            answer = src;
        }
        return answer;
    }

    //добавление в лог-файл
    public void addLogInfoFile(int count) {
        logFile += count + " " + df.format(date) + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Program Files\\Apache Tomcat 9.0.14\\webapps\\ROOT\\WEB-INF\\logger.txt"))) {
            writer.write(logFile);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }


}
