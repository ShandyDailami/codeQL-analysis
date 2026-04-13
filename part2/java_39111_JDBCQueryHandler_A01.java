import java.sql.*;

public class java_39111_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE role = 'admin'";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role");
                    System.out.println("Username: " + username);
                    System.out.println("Role: " + role);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}