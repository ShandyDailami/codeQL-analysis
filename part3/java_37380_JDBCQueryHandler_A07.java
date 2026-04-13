import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37380_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password")) {

            // Prepare a statement
            try (Statement statement = connection.createStatement()) {

                // Execute a query
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {

                    // Process the results
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database.");
            e.printStackTrace();
        }
    }
}