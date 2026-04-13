import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31116_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "user", "password")) {

            // Prepare a statement
            try (Statement statement = connection.createStatement()) {

                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

                // Process the results
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}