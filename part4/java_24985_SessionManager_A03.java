import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_24985_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        Connection connection = manager.getConnection();

        // Use the connection object here...

        manager.closeConnection(connection);
    }
}