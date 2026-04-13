import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_28847_SessionManager_A08 {
    private Connection connection;
    private PreparedStatement statement;

    // Connect to the database
    public java_28847_SessionManager_A08() {
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a query that is only allowed by the session
    public void accessProtectedResource() {
        try {
            statement = connection.prepareStatement("SELECT * FROM protected_table");
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.accessProtectedResource();
    }
}