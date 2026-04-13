import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_31073_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {

            statement.setString(1, "user1");
            statement.setString(2, "password1");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Invalid credentials");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}