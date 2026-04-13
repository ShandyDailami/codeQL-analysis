import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38830_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private static SessionManager instance;

    private java_38830_SessionManager_A08() {
        // private constructor to restrict instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
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

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection conn = sm.getConnection();

        // perform security-sensitive operations here

        sm.closeConnection(conn);
    }
}