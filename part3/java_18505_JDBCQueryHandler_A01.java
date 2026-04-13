import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_18505_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "admin");
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    System.out.println("User found: " + result.getString("username"));
                } else {
                    System.out.println("No user found with the given username.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}