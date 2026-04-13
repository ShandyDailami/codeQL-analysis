import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14105_SessionManager_A08 {

    private static SessionManager instance = null;
    private Connection connection = null;

    // Private constructor to prevent instantiation from outside
    private java_14105_SessionManager_A08() {
        try {
            // Use the specific database driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "user", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance accessor
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}