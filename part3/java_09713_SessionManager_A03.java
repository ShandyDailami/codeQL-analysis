import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09713_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static SessionManager instance;

    private java_09713_SessionManager_A03() {
        // private constructor to prevent instantiation from outside
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}