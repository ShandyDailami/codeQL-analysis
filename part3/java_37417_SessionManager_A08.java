import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37417_SessionManager_A08 {

    // Data source name
    private static final String DATA_SOURCE_NAME = "com.mysql.cj.jdbc.Driver";

    // Database URL
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database username
    private static final String USERNAME = "username";

    // Database password
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_37417_SessionManager_A08() {
        initializeDatabaseConnection();
    }

    private void initializeDatabaseConnection() {
        try {
            Class.forName(DATA_SOURCE_NAME);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to initialize database connection.", e);
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
                throw new RuntimeException("Failed to close database connection.", e);
            }
        }
    }

    // Example of a security-sensitive operation
    public void performIntegrityCheck() {
        try {
            connection.createStatement().execute("SELECT * FROM Users WHERE ID = " + Integer.MAX_VALUE);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to perform integrity check.", e);
        }
    }
}