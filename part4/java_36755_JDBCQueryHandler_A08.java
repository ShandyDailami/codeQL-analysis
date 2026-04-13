import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_36755_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM table_name WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 123); // Replace with the actual id
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        // Process the result set
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }
}