import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07401_SessionManager_A03 {

    // Create a connection to the database
    private Connection connection;

    public java_07401_SessionManager_A03() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to open a session
    public Connection openSession() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to close the session
    public void closeSession(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}