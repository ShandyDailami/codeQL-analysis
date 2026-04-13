import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24969_SessionManager_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    private Connection connection;

    public java_24969_SessionManager_A08() {
        connect();
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null || connection.isClosed()) {
            connect();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}