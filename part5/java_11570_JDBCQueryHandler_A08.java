import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11570_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database!");

            String sql = "SELECT * FROM users";
            try (java.sql.Statement statement = conn.createStatement()) {
                java.sql.ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("User ID: " + resultSet.getString("id"));
                    System.out.println("Username: " + resultSet.getString("username"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}