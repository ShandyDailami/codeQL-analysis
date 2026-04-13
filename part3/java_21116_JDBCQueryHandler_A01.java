import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_21116_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM users WHERE password IS NOT NULL";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            List<String> users = new ArrayList<>();
            while (result.next()) {
                String user = result.getString("username");
                users.add(user);
            }

            System.out.println("Users with non-null password: " + users);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}