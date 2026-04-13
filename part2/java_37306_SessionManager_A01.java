import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37306_SessionManager_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Start a session
            connection.setAutoCommit(false);

            // Perform operations on the connection
            // ...

            // Close the session
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}