import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22960_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
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
        SessionManager sm = new SessionManager();
        Connection connection = sm.getConnection();
        // perform security-sensitive operations with the connection here
        sm.closeConnection(connection);
    }
}