import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_40180_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            conn.setSecurityManager(securityManager);

            // Assume that the user is authorized to access this database
            // This is a simple example and does not cover all possible scenarios
            conn.createStatement().execute("SELECT * FROM Users");

            // Assume that the user is not authorized to access this database
            conn.createStatement().execute("SELECT * FROM Orders");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}