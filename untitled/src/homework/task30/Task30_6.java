package homework.task30;

/*Составить следующие запросы:
Вывести список получателей платежей, и сумму платежей по каждому из них.
Вывести сумму платежей за тот день, когда был наибольший платёж.
Вывести наибольший платёж за тот день, когда сумма платежей была наибольшей.*/

import java.sql.*;

public class Task30_6 {
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

            String query = "SELECT r.name, SUM(e.value) FROM expenses AS e, receivers AS r WHERE e.receiver=r.num GROUP BY r.name";
            printResult(statement, query);

            String query01 = "SELECT paydate, SUM(value) FROM expenses WHERE paydate=(SELECT paydate FROM expenses WHERE value=(SELECT MAX(value) FROM expenses))";
            printResult(statement, query01);

            String query02 = "SELECT paydate, MAX(value) FROM expenses WHERE paydate = (SELECT paydate FROM expenses GROUP BY paydate ORDER BY SUM(value) DESC LIMIT 1)";
            printResult(statement, query02);

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

    public static void printResult(Statement statement, String query) {
        try {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                System.out.print(result.getString(1) + " - ");
                System.out.println(result.getInt(2));
            }
            System.out.println("------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
