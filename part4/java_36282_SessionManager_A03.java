import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36282_SessionManager_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private java_36282_SessionManager_A03() {
        // Private constructor to prevent instantiation of the class
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            // Perform security-sensitive operations related to injection attacks here
            // For example, use the connection to run SQL queries
            conn.createStatement().execute("INSERT INTO Users (username, password) VALUES ('test', 'test')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}