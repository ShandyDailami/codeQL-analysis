import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_14717_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        createUser("John", "john@example.com");
        createUser("Mary", "mary@example.com");
    }

    private static void createUser(String username, String email) {
        String query = "INSERT INTO Users (username, email) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, email);

            statement.executeUpdate();

            System.out.println("User created: " + username + ", " + email);

        } catch (SQLException e) {
            System.err.println("Error while creating user: " + e.getMessage());
        }
    }
}