import java.sql.*;

public class java_09761_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "john"); // replace with the actual username
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String dbPassword = result.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed! Password mismatch.");
                }
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}