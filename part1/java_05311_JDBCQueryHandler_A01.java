import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_05311_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT sensitive_info FROM table_name WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 123); // Replace 123 with the actual id

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String sensitiveInfo = resultSet.getString("sensitive_info");
                        System.out.println("Sensitive info: " + sensitiveInfo);
                    } else {
                        System.out.println("No sensitive info found for the given id.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}