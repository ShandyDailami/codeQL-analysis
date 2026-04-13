import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_10347_SessionManager_A03 {

    // The standard way to handle database connections.
    private Connection connection;

    public java_10347_SessionManager_A03(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle connection exception here.
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle connection close exception here.
            }
        }
    }
}