package task30_13;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    HashSet<String> cookiesHashSet;

    DifferentMethods df = new DifferentMethods();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cookiesHashSet = new HashSet<>();
        int x = 0;
        String cookieName = "testCookie" + x;

        //создаём и добавляем новый куки
        Cookie myCookie = new Cookie(cookieName, "" + x);
        myCookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(myCookie);
        x++;

        //данные для перекодирования текста
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

        //получение куки и их занесение коллекцию
        Cookie[] myCookies = req.getCookies();
        synchronized (myCookies) {
            if (myCookies != null) {
                for (int i = 0; i < myCookies.length; i++) {
                    Cookie cookie = myCookies[i];
                    cookiesHashSet.add(cookie.getName());
                }
            } else {
                cookiesHashSet.add(cookieName);
            }
        }

        // вывод результата
        out.println("<html><head><title>Data Servlet</title></head>");
        out.println(df.encode("<body><h1>Количество поситителей " + cookiesHashSet.size() + ".</h1></body></html>", dstPage, srcPage));
        df.addLogInfoFile(cookiesHashSet.size());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}