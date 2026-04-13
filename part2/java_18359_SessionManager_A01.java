import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18359_SessionManager_A01 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Constructor
    public java_18359_SessionManager_A01() {
        connectToDatabase();
    }

    // Method to create a connection to the database
    private Connection connectToDatabase() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection successful");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Method to create a session
    public void createSession() {
        try (Connection conn = this.connectToDatabase()) {
            if (conn != null) {
                System.out.println("Session created");
            }
        } catch (SQLException e) {
            System.out.println("Error while creating session: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        new SessionManager();
    }
}