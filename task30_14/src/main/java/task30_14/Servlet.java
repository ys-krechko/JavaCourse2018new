package task30_14;

import dao.MyDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MyDao myDao = MyDao.getMyDao();
    WorkingWithDatabase database;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String user = getInitParameter("user");
        String password = getInitParameter("password");
        database = new WorkingWithDatabase(myDao);
        database.getDatabaseContent(user, password);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        ServletConfig conf = getServletConfig();
        String user = conf.getInitParameter("user");
        String password = conf.getInitParameter("password");
*/

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
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Data Servlet</title></head>");
        out.println("<body>");
        database.printExpenseContent(out, dstPage, srcPage);
        out.println("=======================================");
        database.printReceiverContent(out, dstPage, srcPage);
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}