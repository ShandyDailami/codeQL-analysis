import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03053_SessionManager_A03 {
    private static SecureSessionManager instance;

    private java_03053_SessionManager_A03() {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SecureSessionManager getInstance() {
        if (instance == null) {
            instance = new SecureSessionManager();
        }
        return instance;
    }

    public Connection getConnection(String username, String password) throws SQLException {
        // Connect to the database
        String url = "jdbc:mysql://localhost:3306/test";
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) {
        // Close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}