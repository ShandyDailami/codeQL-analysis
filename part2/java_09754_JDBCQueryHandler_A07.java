import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_09754_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection to database successful!");

            // Here's an example of a query, replace it with your actual query
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            connection.prepareStatement(sql).setString(1, "user1").setString(2, "password1").execute();

            // Here's another example of a query, replace it with your actual query
            sql = "SELECT * FROM orders WHERE user_id = ?";
            connection.prepareStatement(sql).setInt(1, 123).execute();

        } catch (SQLException e) {
            System.out.println("Connection to database failed: " + e.getMessage());
        }
    }
}