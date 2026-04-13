import javax.management.AuthenticationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_35668_SessionManager_A01 {
    private static SessionManager sessionManager;
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase";
    private static String username = "root";
    private static String password = "root";
    private Connection connection;

    private java_35668_SessionManager_A01() {
        try {
            Class.forName(driverName);
            this.connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getSessionManager() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}