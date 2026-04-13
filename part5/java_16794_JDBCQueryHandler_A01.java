import java.sql.*;

public class java_16794_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testuser"); // The user to get the password for

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String password = result.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}