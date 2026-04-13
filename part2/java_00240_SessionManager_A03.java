import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00240_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_00240_SessionManager_A03() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}