import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_27284_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Example of a secure operation
            String selectQuery = "SELECT * FROM Users WHERE username = ?";
            connection.prepareStatement(selectQuery).setString(1, "user1");

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}