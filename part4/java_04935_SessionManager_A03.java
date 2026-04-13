import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04935_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private java_04935_SessionManager_A03() {
        // private constructor to prevent instantiation
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
        // use the session here
    }
}