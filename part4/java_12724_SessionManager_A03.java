import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12724_SessionManager_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    private java_12724_SessionManager_A03() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("Connection successful!");
            conn.close();
        } else {
            System.out.println("Connection failed!");
        }
    }
}