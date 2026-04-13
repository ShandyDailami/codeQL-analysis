import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07341_SessionManager_A03 {
    private static SessionManager instance;

    private java_07341_SessionManager_A03() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}