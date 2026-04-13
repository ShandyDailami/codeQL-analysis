import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36151_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "testUser");
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    System.out.println("User found!");
                } else {
                    System.out.println("User not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}