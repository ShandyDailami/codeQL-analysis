import java.sql.*;

public class java_39114_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Query 1: Select all employees who have worked more than 5 years
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees WHERE YEAR(CURDATE()) - YEAR(Birthdate) > 5");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                Date birthdate = resultSet.getDate("Birthdate");
                Date currentDate = new Date();
                long years = TimeUnit.MILLISECONDS.toDays(currentDate.getTime() - birthdate.getTime()) / 365;

                System.out.println("Name: " + name + ", Years: " + years);
            }

            // Query 2: Select all employees who are currently working
            resultSet = statement.executeQuery("SELECT * FROM Employees WHERE Status = 'Current'");

            while (resultSet.next()) {
                String name = resultSet.getString("Name");

                System.out.println("Name: " + name);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}