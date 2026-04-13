import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18296_SessionManager_A01 {
    private static SessionManager instance;
    private Connection connection;

    private java_18296_SessionManager_A01() {
        try {
            // Assuming your DB URL, username, and password are correct.
            // You should handle these in a real application.
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "username", "password");
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Failed to initialize database connection: " + e.getMessage());
        }
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Handle the exception appropriately
            }
        }
    }
}