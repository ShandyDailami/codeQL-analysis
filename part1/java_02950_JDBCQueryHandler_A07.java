import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_02950_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");

            // Assuming you want to insert a new user into the database
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            connection.prepareStatement(sql).setString(1, "newUser").setString(2, "newPassword").executeUpdate();

            // Assuming you want to retrieve a user from the database
            sql = "SELECT * FROM Users WHERE username = ?";
            java.sql.ResultSet rs = connection.prepareStatement(sql).setString(1, "newUser").executeQuery();
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }

            // Assuming you want to update a user's password
            sql = "UPDATE Users SET password = ? WHERE username = ?";
            connection.prepareStatement(sql).setString(1, "newPassword").setString(2, "newUser").executeUpdate();

            // Assuming you want to delete a user
            sql = "DELETE FROM Users WHERE username = ?";
            connection.prepareStatement(sql).setString(1, "newUser").executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}