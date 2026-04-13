import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33164_SessionManager_A03 {
    // Step 1: Establish the database connection
    private Connection connection;

    public java_33164_SessionManager_A03() {
        try {
            // Step 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish connection to the database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 4: Implement a security-sensitive operation
    public void performOperation() {
        // Step 5: Open a session (if not already open)
        if (connection.isClosed()) {
            try {
                connection.close();
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/testdb", "username", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Step 6: Perform the security-sensitive operation
        try {
            connection.createStatement().execute("SELECT * FROM Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 7: Close the connection when done
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.performOperation();
        manager.closeConnection();
    }
}