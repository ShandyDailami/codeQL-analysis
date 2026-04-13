import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13392_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    // Method to establish a connection to the database
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error while connecting to database: " + e.getMessage());
            return null;
        }
        return connection;
    }

    // Method to execute SQL queries
    public static void executeQuery(String query) {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Failed to connect to database.");
            return;
        }

        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
            System.out.println("Query executed successfully.");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of a SQL query
        String query = "SELECT * FROM Users WHERE username = 'test' AND password = 'test'";
        executeQuery(query);
    }
}