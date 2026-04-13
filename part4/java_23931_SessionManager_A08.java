import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23931_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;

    private java_23931_SessionManager_A08() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
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

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}