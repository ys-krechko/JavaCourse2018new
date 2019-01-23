package homework.task30;

/*Напишите программу получающую данные о расходе в качестве исходных параметров main, и добавляющую
этот расход в базу, после чего выводящую таблицу расходов на экран.*/

import java.sql.*;

public class Task30_4 {
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
                    + " VALUES('Интернет-провайдер \"Соло\"')";
            statement.executeUpdate(insertRSql);
            String insertR2Sql = "INSERT INTO receivers (name)"
                    + " VALUES('Гипермаркет \"Корона\"')";
            statement.executeUpdate(insertR2Sql);
            String insertR3Sql = "INSERT INTO receivers (name)"
                    + " VALUES('МТС')";
            statement.executeUpdate(insertR3Sql);

            String tableSql = "CREATE TABLE IF NOT EXISTS expenses"
                    + "(num int PRIMARY KEY AUTO_INCREMENT, paydate date,"
                    + "receiver int, value dec," +
                    "FOREIGN KEY(receiver) REFERENCES receivers (num))";
            statement.execute(tableSql);
            String insertSql = "INSERT INTO expenses(paydate, receiver, value)"
                    + " VALUES('10.05.2011', 1, 20000)";
            statement.executeUpdate(insertSql);
            String insert2Sql = "INSERT INTO expenses(paydate, receiver, value)"
                    + " VALUES('10.05.2011', 2, 94200)";
            statement.executeUpdate(insert2Sql);
            String insert3Sql = "INSERT INTO expenses(paydate, receiver, value)"
                    + " VALUES('11.05.2011', 3, 10000)";
            statement.executeUpdate(insert3Sql);
            String insert4Sql = "INSERT INTO expenses(paydate, receiver, value)"
                    + " VALUES('11.05.2011', 2, 12950)";
            statement.executeUpdate(insert4Sql);

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
