import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29601_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private java_29601_SessionManager_A01() {
        // Prevent instantiation of the class
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to database successfully!");
        } else {
            System.out.println("Failed to connect to database!");
        }
    }
}