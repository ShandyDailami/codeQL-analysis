import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_13750_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testuser");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usernameFromDB = resultSet.getString("username");
                System.out.println("Username from database: " + usernameFromDB);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}