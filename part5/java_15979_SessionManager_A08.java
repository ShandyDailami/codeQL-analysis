import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15979_SessionManager_A08 {

    private static SessionManager instance = null;

    private java_15979_SessionManager_A08() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        Connection conn = sm.getConnection();

        // Sensitive operations related to integrity failure
        // ...

        sm.closeConnection(conn);
    }
}