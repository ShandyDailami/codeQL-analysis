import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_37285_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Assume this is your database url
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM user WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 123); // Assuming user id 123 is safe
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    // Do something with the user
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}