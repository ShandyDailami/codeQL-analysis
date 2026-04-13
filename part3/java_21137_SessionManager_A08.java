import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21137_SessionManager_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    private java_21137_SessionManager_A08() {}

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connected to the database");
        } else {
            System.out.println("Failed to connect to the database");
            System.exit(1);
        }
    }
}