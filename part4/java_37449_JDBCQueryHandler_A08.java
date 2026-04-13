import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_37449_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static List<String> fetchUsersByUsername(String username) {
        List<String> userList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT username FROM Users WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                userList.add(result.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}