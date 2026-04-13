import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_15289_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "user1");
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String passwordFromDB = result.getString("password");
                    System.out.println("Password from DB: " + passwordFromDB);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}