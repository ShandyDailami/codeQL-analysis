import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01195_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // This line is security-sensitive. It opens a connection, but immediately closes it
        connection.close();

        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = new SecureSessionManager().getConnection();
            // Your code here...
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}