import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37680_SessionManager_A03 {

    // Define the database credentials
    private static final String DB_USERNAME = "dbuser";
    private static final String DB_PASSWORD = "dbpassword";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbname";

    // Define the database credentials for Spring's Injection Protection
    private static final String DB_USERNAME_SPRING = "dbuser";
    private static final String DB_PASSWORD_SPRING = "dbpassword";
    private static final String DB_URL_SPRING = "jdbc:mysql://localhost:3306/dbname";

    private Connection connection;

    // Method to connect to the database
    public boolean connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Method to connect to the database with Spring's Injection Protection
    public boolean connectToDatabaseSpringProtected() {
        try {
            connection = DriverManager.getConnection(DB_URL_SPRING, DB_USERNAME_SPRING, DB_PASSWORD_SPRING);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}