import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_28325_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "user1");
            statement.setString(2, "password1");
            statement.executeUpdate();

            statement.setString(1, "user2");
            statement.setString(2, "password2");
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}