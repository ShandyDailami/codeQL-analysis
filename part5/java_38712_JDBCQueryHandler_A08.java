import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38712_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM Users WHERE role = 'Admin' AND password = 'mypass'";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role");
                    System.out.println("Username: " + username);
                    System.out.println("Role: " + role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}