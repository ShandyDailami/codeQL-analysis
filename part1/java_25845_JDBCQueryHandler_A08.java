import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25845_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        // Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            // Execute a query
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM mytable";
                ResultSet resultSet = statement.executeQuery(sql);

                // Process the result
                while (resultSet.next()) {
                    System.out.println("Row 1: " + resultSet.getString("mycolumn"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }
}