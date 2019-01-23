package task30_14;

import dao.Expense;
import dao.MyDao;
import dao.Receiver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class WorkingWithDatabase {
    MyDao myDao;

    public WorkingWithDatabase(MyDao myDao) {
        this.myDao = myDao;
    }

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

    // получение данных из БД
    public void getDatabaseContent(String user, String password) {
        Connection connection;
        String dbURL = "jdbc:mysql://localhost:3306/task30" +
                "?useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false" +
                "&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement();

            String query = "SELECT num, paydate, receiver, value FROM expenses";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Expense expense = new Expense();
                expense.setNum(result.getInt("num"));
                expense.setPaydate(result.getString("paydate"));
                expense.setReceiver(result.getInt("receiver"));
                expense.setValue(result.getInt("value"));
                myDao.addExpense(expense);
            }

            String query1 = "SELECT num, name FROM receivers";
            ResultSet result1 = statement.executeQuery(query1);
            while (result1.next()) {
                Receiver receiver = new Receiver();
                receiver.setNum(result1.getInt("num"));
                receiver.setName(result1.getString("name"));
                myDao.addReceiver(receiver);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void printExpenseContent(PrintWriter out, String dstPage, String srcPage) throws IOException {
        out.println("<h1>Expense Table</h1>");
        out.println("<h2>Num  Paydate  Receiver  Value</h2>");
        for (Expense exp : myDao.getExpenses()) {
            out.println("<h3>" + exp.getNum() + "  " + exp.getPaydate() + "  " + exp.getReceiver() + "  " + exp.getValue() + "</h3>");
            out.println("<h3></h3>");
        }
    }

    public void printReceiverContent(PrintWriter out, String dstPage, String srcPage) throws IOException {
        out.println("<h1>Receiver Table</h1>");
        out.println("<h2>Num  Name</h2>");
        for (Receiver rec : myDao.getReceivers()) {
            out.println(encode("<h3>" + rec.getNum() + "  " + rec.getName() + "</h3>", dstPage, srcPage));
            out.println("<h3></h3>");
        }
    }
}
