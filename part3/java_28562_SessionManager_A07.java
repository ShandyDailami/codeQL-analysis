import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28562_SessionManager_A07 {
    // Database URL
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    // Database username
    private static final String USERNAME = "root";
    // Database password
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_28562_SessionManager_A07() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
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
            }
        }
    }
}