import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09397_SessionManager_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private java_09397_SessionManager_A01() {
        // Private constructor to prevent instantiation of the class
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        // Use the connection to perform operations related to A01_BrokenAccessControl
        // ...
        connection.close();
    }
}