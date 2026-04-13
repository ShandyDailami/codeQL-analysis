import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27865_SessionManager_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static SessionManager instance;

    private java_27865_SessionManager_A03() {
        // private constructor to prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while getting connection: " + e.getMessage());
        }
        return connection;
    }
}