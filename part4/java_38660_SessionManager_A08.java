import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38660_SessionManager_A08 {
    // The URL of the database
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    // The username for the database connection
    private static final String USERNAME = "root";
    // The password for the database connection
    private static final String PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        // Establish a connection to the database
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        // Close the connection to the database
        if (connection != null) {
            connection.close();
        }
    }
}