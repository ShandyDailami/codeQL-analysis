import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00695_SessionManager_A03 {
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";

    // Singleton instance
    private static SessionManager instance;

    // Private constructor to enforce instantiation through the getInstance() method
    private java_00695_SessionManager_A03() {
        // Load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Public method to get the instance (Singleton)
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Method to get a connection
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close the connection
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}