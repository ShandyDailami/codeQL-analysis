import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class java_05183_JDBCQueryHandler_A03 {
    private static final List<String> USERS = Arrays.asList("User1", "User2", "User3");

    public List<String> getUsers(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String user = result.getString("username");
                USERS.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return USERS;
    }
}