import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_13153_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameters
            statement.setString(1, "newPassword");
            statement.setString(2, "newUser");

            // Execute the query
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Updated rows: " + rowsUpdated);

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}