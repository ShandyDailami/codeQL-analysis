import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11588_SessionManager_A08 {
    private Connection connection;

    public java_11588_SessionManager_A08(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}