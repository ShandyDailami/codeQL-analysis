import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01080_SessionManager_A03 {

    private static SessionManager instance;

    private Connection connection;

    private java_01080_SessionManager_A03() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
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