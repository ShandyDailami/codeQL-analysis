import java.sql.*;

public class java_26734_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Select all data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            // Insert data
            statement.executeUpdate("INSERT INTO employees (name) VALUES ('John')");

            // Update data
            statement.executeUpdate("UPDATE employees SET name = 'Jane' WHERE name = 'John'");

            // Delete data
            statement.executeUpdate("DELETE FROM employees WHERE name = 'Jane'");

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}