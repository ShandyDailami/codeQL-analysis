import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02159_SessionManager_A03 {

    // Define the database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private java_02159_SessionManager_A03() {
        // Private constructor to prevent instantiation of the class
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connected to database!");
        }
    }
}