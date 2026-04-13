import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39829_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Connection string
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful");
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM Users";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}