import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01678_SessionManager_A08 {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private static SessionManager instance;
    private Connection connection;

    // Private constructor to avoid instantiation
    private java_01678_SessionManager_A08() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASS);

            // Set autocommit mode to false to allow us to manually commit changes
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // SQL query executor
    public void executeQuery(String query) {
        try {
            // Execute query
            connection.createStatement().execute(query);

            // Commit changes
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SessionManager sm = SessionManager.getInstance();
        sm.executeQuery("INSERT INTO Users (username, email) VALUES ('test', 'test@test.com')");
    }
}