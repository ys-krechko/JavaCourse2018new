package task30_12;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        String output = "This is First Servlet. Visitors: " + count;
        resp.setContentType("image/jpeg");

        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 28));
        graphics.setColor(Color.green);
        graphics.drawString(output, 100, 100);

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);

        count++;
        addLogInfoFile(count);
    }
}