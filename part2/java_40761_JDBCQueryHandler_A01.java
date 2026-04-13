import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_40761_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish the connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password")) {

            // Step 3: Execute a query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

                // Step 4: Process the result set
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}