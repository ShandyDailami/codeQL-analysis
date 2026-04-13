import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11275_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Start a new transaction
            connection.setAutoCommit(false);

            // Do some database operations here
            // ...

            // Commit the transaction
            connection.commit();

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}