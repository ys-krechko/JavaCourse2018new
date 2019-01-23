package homework.task21_6;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class ProgramLogger {
    private static ProgramLogger logger;
    private static String logFile = "This is log file. \n\n";

    Date date = new Date();
    DateFormat df = DateFormat.getDateTimeInstance();

    private ProgramLogger() {

    }

    public static synchronized ProgramLogger getLogger() {
        if (logger == null) {
            logger = new ProgramLogger();
        }
        return logger;
    }


    public void addLogInfoFile(String logInfo) {
        logFile += logInfo + " " + df.format(date) + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task21_6\\logger.txt"))) {
            writer.write(logFile);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }

    public void readLogFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\homework\\task21_6\\logger.txt"))) {
            String x;
            while ((x = reader.readLine()) != null) {
                System.out.println(x);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }
}
