import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class java_34176_JDBCQueryHandler_A08 {
    // Static list of users and their passwords
    private static final List<User> users = Arrays.asList(
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3"));

    // Query database for a user
    public boolean authenticate(String username, String password) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:your_database_url", "username", "password")) {

            // Prepare statement
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            ResultSet result = statement.executeQuery();

            // If there is a result, return true
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return false if no user was found
        return false;
    }

    // User class
    public static class User {
        private String username;
        private String password;

        public java_34176_JDBCQueryHandler_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}