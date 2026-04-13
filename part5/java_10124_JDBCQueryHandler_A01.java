import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_10124_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        System.out.println("User ID: " + resultSet.getInt("id"));
                        System.out.println("User Name: " + resultSet.getString("name"));
                        System.out.println("User Email: " + resultSet.getString("email"));
                        System.out.println("------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database: " + e.getMessage());
        }
    }
}