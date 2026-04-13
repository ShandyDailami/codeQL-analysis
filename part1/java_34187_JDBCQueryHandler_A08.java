import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_34187_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT COUNT(*) FROM Users";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int totalUsers = resultSet.getInt(1);
                System.out.println("Total users: " + totalUsers);
            } else {
                System.out.println("No users found.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}