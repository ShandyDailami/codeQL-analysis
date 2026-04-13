import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17243_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Create session
            connection.setAutoCommit(false);

            // Log in a user
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)")) {
                statement.setString(1, "user1");
                statement.setString(2, "password1");
                statement.executeUpdate();
            }

            // Retrieve user information
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?")) {
                statement.setString(1, "user1");
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("User found: " + resultSet.getString("username"));
                    } else {
                        System.out.println("No user found with that username");
                    }
                }
            }

            // Log out the user
            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE username = ?")) {
                statement.setString(1, "user1");
                statement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}