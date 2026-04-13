import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14831_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            statement.executeUpdate();

            sql = "SELECT * FROM users";
            statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String user = result.getString("username");
                String pass = result.getString("password");

                System.out.println("User: " + user + ", Password: " + pass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}