import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_15562_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test"; // change the URL according to your database
        String username = "username"; // change the username according to your database user
        String password = "password"; // change the password according to your database user

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Authenticate to the database using the credentials above
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}