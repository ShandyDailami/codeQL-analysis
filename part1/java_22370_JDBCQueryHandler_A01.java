import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_22370_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "testuser");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usernameFromDb = resultSet.getString("username");
                System.out.println("Username from database: " + usernameFromDb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}