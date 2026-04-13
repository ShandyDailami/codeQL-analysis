import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39003_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM users WHERE role='ADMIN'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String role = resultSet.getString("role");
                System.out.println("Role: " + role);
            }

        } catch (SQLException e) {
            System.out.println("Error handling database operations: " + e.getMessage());
        }
    }
}