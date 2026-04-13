import java.sql.*;

public class java_19873_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "valid_username");
                statement.setString(2, "valid_password");

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String usernameFromDB = result.getString("username");
                    String passwordFromDB = result.getString("password");

                    System.out.println("Username from DB: " + usernameFromDB);
                    System.out.println("Password from DB: " + passwordFromDB);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}