import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35918_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection connection;

    private java_35918_SessionManager_A03() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}