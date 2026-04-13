import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05386_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users u LEFT JOIN orders o ON u.user_id = o.user_id";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    int userId = result.getInt("user_id");
                    String userName = result.getString("user_name");
                    int orderId = result.getInt("order_id");
                    System.out.println("User ID: " + userId);
                    System.out.println("User Name: " + userName);
                    System.out.println("Order ID: " + orderId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        }
    }
}