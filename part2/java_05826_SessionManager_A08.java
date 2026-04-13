import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_05826_SessionManager_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Use the connection
            // Here, we're just establishing a session. In a real-world application,
            // you'd probably want to use this connection to interact with your database.
            // For instance, you could execute SQL queries or handle transactions.

            // Here's how you could create a session:
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            // ...

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}