package task30_11;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static public String encode(String src, String defpage, String codepage) {
        String answer = "";
        try {
            answer = new String(src.getBytes(defpage), codepage);
        } catch (Throwable e) {
            answer = src;
        }
        return answer;
    }

    static public String browserIdentification(String info) {
        int x = 0;
        String browser;
        if (info.contains("Chrome")) {
            x = 1;
        } else if (info.contains("Mozilla")) {
            x = 2;
        } else if (info.contains("Internet Explorer")) {
            x = 3;
        }
        switch (x) {
            case 1:
                browser = "Chrome";
                break;
            case 2:
                browser = "Mozilla";
                break;
            case 3:
                browser = "Internet Explorer";
                break;
            default:
                browser = "Unknown browser";
                break;
        }
        return browser;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getHeader("User-Agent");

        String srcPage = req.getCharacterEncoding();
        if (srcPage == null) {
            srcPage = "ISO-8859-1";
        }
        String dstPage = req.getParameter("charset");
        if (dstPage == null) {
            dstPage = "windows-1251";
        }
        resp.setContentType("text/html, charset=windows-1251");
        ServletOutputStream out = resp.getOutputStream();

        out.println("<html><head><title>Data Servlet</title></head>");
        out.println(encode("<body><h1>Приветствую пользователя " + browserIdentification(info) + ".</h1>", dstPage, srcPage));
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}