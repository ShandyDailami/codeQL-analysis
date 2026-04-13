import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33889_SessionManager_A03 {

    // Database credentials
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Singleton instance
    private static SessionManager instance;

    // Private constructor to prevent instantiation from other classes
    private java_33889_SessionManager_A03() {
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Public method to get the instance of the SessionManager
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to get a database connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close the database connection
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}