import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12829_SessionManager_A07 {
    private static SessionManager instance;

    private java_12829_SessionManager_A07() {
        // Prevent instantiation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Connection connection;

    public void connectToDatabase(String dbUrl, String username, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void disconnectFromDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from database");
            } catch (SQLException e) {
                System.out.println("Failed to disconnect from database: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}