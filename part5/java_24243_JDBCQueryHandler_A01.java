import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_24243_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_24243_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public List<String> getUserRoles(String username) {
        List<String> roles = new ArrayList<>();

        String sql = "SELECT role FROM users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                roles.add(result.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            List<String> roles = handler.getUserRoles("user");

            for (String role : roles) {
                System.out.println("User role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}