import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_03112_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Create a connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Use the connection to perform operations
        try {
            // This is a placeholder operation. In a real application, this would be a query to the database.
            connection.createStatement().execute("INSERT INTO Users (username, password) VALUES ('test', 'test')");
            System.out.println("Successfully performed operation on the database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}