import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_23772_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 1);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String name = result.getString("name");
                    String email = result.getString("email");
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in connecting to database or executing query: " + e.getMessage());
        }
    }
}