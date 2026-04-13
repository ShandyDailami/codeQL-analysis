import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_21954_SessionManager_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection to the database
    public Connection openConnection() throws ClassNotFoundException, SQLException {
        // Load the MySQL driver
        Class.forName(DB_DRIVER);

        // Establish a connection to the database
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Close the connection to the database
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    // Main method
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Open a connection
        Connection connection = sessionManager.openConnection();

        // Perform an operation that could be insecure
        // In this example, we're writing to the database.
        // This operation should not be done with a session, but rather with raw SQL.
        // sessionManager.executeUpdate("INSERT INTO test_table VALUES (1, 'test')");

        // Close the connection
        sessionManager.closeConnection(connection);
    }
}