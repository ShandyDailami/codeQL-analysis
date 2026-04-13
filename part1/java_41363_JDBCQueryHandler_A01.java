import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41363_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "UPDATE users SET password = 'newPassword' WHERE username = 'user'";
            statement.executeUpdate(sql);

            System.out.println("Password updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}