package task30_9;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int count = 0;
    private static String logFile = "This is log file. \n\n";

    Date date = new Date();
    DateFormat df = DateFormat.getDateTimeInstance();

    public void addLogInfoFile(int count) {
        logFile += count + " " + df.format(date) + "\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Program Files\\Apache Tomcat 9.0.14\\webapps\\ROOT\\WEB-INF\\logger.txt"))) {
            writer.write(logFile);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-ввывода: " + e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>First Servlet</title></head>");
        out.println("<body><h1>This is First Servlet. Visitors: " + count + "</h1>");
        out.println("</body></html>");
        count++;
        addLogInfoFile(count);
    }
}
