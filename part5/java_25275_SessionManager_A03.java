import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_25275_SessionManager_A03 {
    private static String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static String username = "root";
    private static String password = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}