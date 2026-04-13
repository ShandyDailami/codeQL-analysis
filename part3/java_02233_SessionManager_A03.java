import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02233_SessionManager_A03 {
    private static SessionManager sessionManager;
    private static Connection connection;

    // private constructor to prevent instantiation
    private java_02233_SessionManager_A03() {
        // establish database connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // singleton instance accessor
    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }

        return sessionManager;
    }

    // database accessor
    public Connection getConnection() {
        return this.connection;
    }
}