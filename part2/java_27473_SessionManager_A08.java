import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27473_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 3. Use the connection to perform an operation
            insertUser(connection, "John Doe", "john@example.com");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the database connection");
                }
            }
        }
    }

    private static void insertUser(Connection connection, String name, String email) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
        try {
            connection.prepareStatement(sql).executeUpdate();
            System.out.println("User inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting user into the database");
        }
    }
}