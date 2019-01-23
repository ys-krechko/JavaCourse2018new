package homework.task30;

/*Измените предыдущую задачу таким образом, чтобы она использовала прекомпилированные запросы.*/

import java.math.BigDecimal;
import java.sql.*;

public class Task30_5 {
    public static void main(String[] args) {
        Connection connection;
        String dbURL = "jdbc:mysql://localhost:3306/task30" +
                "?useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false" +
                "&serverTimezone=UTC";
        String user = "admin";
        String password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(dbURL, user, password);
            Statement statement = connection.createStatement();

            String tableRSql = "CREATE TABLE IF NOT EXISTS receivers"
                    + "(num int PRIMARY KEY AUTO_INCREMENT," +
                    "name varchar(255))";
            statement.execute(tableRSql);

            String insertRSql = "INSERT INTO receivers (name)"
                    + " VALUES(?)";
            PreparedStatement pStatementRec = connection.prepareStatement(insertRSql);
            pStatementRec.setString(1, "Интернет-провайдер \"Соло\"");
            pStatementRec.executeUpdate();
            pStatementRec.setString(1, "Гипермаркет \"Корона\"");
            pStatementRec.executeUpdate();
            pStatementRec.setString(1, "МТС");
            pStatementRec.executeUpdate();

            String tableSql = "CREATE TABLE IF NOT EXISTS expenses"
                    + "(num int PRIMARY KEY AUTO_INCREMENT, paydate date,"
                    + "receiver int, value dec," +
                    "FOREIGN KEY(receiver) REFERENCES receivers (num))";
            statement.execute(tableSql);

            String insertSql = "INSERT INTO expenses(paydate, receiver, value)"
                    + " VALUES(?, ?, ?)";
            PreparedStatement pStatementExp = connection.prepareStatement(insertSql);
            pStatementExp.setString(1, "10.05.2011");
            pStatementExp.setInt(2, 1);
            pStatementExp.setBigDecimal(3, BigDecimal.valueOf(20000));
            pStatementExp.executeUpdate();
            pStatementExp.setString(1, "10.05.2011");
            pStatementExp.setInt(2, 2);
            pStatementExp.setBigDecimal(3, BigDecimal.valueOf(94200));
            pStatementExp.executeUpdate();
            pStatementExp.setString(1, "11.05.2011");
            pStatementExp.setInt(2, 3);
            pStatementExp.setBigDecimal(3, BigDecimal.valueOf(10000));
            pStatementExp.executeUpdate();
            pStatementExp.setString(1, "11.05.2011");
            pStatementExp.setInt(2, 2);
            pStatementExp.setBigDecimal(3, BigDecimal.valueOf(12950));
            pStatementExp.executeUpdate();

            String query = "SELECT num, paydate, receiver, value FROM expenses";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                System.out.print(result.getString("num") + " ");
                System.out.print(result.getString("paydate") + " ");
                System.out.print(result.getString("receiver") + " ");
                System.out.print(result.getString("value"));
                System.out.println();
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
}
