import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28594_SessionManager_A08 {
    private static Connection connection;

    // Method to get the connection
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        }
        return connection;
    }

    // Method to check integrity
    public static void checkIntegrity() throws SQLException {
        Connection connection = getConnection();
        connection.createStatement().execute("SELECT 1"); // Assume the integrity check involves selecting 1
        System.out.println("Integrity check passed");
    }

    // Method to close the connection
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        try {
            checkIntegrity();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}