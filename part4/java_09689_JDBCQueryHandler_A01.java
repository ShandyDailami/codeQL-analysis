import java.sql.*;

public class java_09689_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Query 1: Insert a new user
        String query1 = "INSERT INTO users (username, password) VALUES (?, ?)";
        insertUser("user1", "password1");

        // Query 2: Select a user by username
        String query2 = "SELECT * FROM users WHERE username = ?";
        ResultSet result = selectUser("user1");

        // Query 3: Update a user's password
        String query3 = "UPDATE users SET password = ? WHERE username = ?";
        updatePassword("new_password", "user1");

        // Query 4: Delete a user
        String query4 = "DELETE FROM users WHERE username = ?";
        deleteUser("user1");
    }

    private static void insertUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query1)) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet selectUser(String username) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query2)) {

            statement.setString(1, username);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void updatePassword(String newPassword, String username) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query3)) {

            statement.setString(1, newPassword);
            statement.setString(2, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(String username) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query4)) {

            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}