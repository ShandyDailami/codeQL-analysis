import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34436_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager sessionManager;

    private java_34436_SessionManager_A03() {
        // Private constructor to restrict instantiation of this class from outside
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}