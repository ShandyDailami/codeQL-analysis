import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_12169_SessionManager_A03 {
    // Step 1: Define the JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    // Step 2: Define the database URL and credentials
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Step 3: Create the connection
    private Connection connection;

    public java_12169_SessionManager_A03() {
        try {
            // Step 4: Load the JDBC driver
            Class.forName(DRIVER);
            // Step 5: Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 6: Provide the connection
    public Connection getConnection() {
        return connection;
    }

    // Step 7: Close the connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 8: Main method to test the connection
    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        // Step 9: Use the connection
        try {
            if (sessionManager.getConnection().createStatement().execute("select * from users")) {
                System.out.println("Connection successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sessionManager.closeConnection();
        }
    }
}