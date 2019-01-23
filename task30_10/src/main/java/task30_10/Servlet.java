package task30_10;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProcessingExceptions prEx = new ProcessingExceptions();

    static public String encode(String src, String defpage, String codepage) {
        String answer = "";
        try {
            answer = new String(src.getBytes(defpage), codepage);
        } catch (Throwable e) {
            answer = src;
        }
        return answer;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String srcPage = req.getCharacterEncoding();
        if (srcPage == null) {
            srcPage = "ISO-8859-1";
        }
        String dstPage = req.getParameter("charset");
        if (dstPage == null) {
            dstPage = "windows-1251";
        }
        resp.setContentType("text/html, charset=windows-1251");

        PrintWriter out = resp.getWriter();

        try {
            String name = req.getParameter("user_name");
            String phoneNumber = req.getParameter("phone_number");
            String email = req.getParameter("email_address");

            prEx.process(out, name, phoneNumber, email);
        } catch (MissingNameException e) {
            out.println(encode("<html><body><h1>" + e + "</body></h1></html>", dstPage, srcPage));
        } catch (MissingEmailAndPhoneNumberException e) {
            out.println(encode("<html><body><h1>" + e + "</body></h1></html>", dstPage, srcPage));
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}