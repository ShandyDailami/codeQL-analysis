import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33014_SessionManager_A03 {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Driver class name for MySQL JDBC driver
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Constructor to load the driver
    public java_33014_SessionManager_A03() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Main method to open a connection and close it
    public void performOperation() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Code for performing operations with the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}