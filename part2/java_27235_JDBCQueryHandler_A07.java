import java.sql.*;

public class java_27235_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "invalidUser"); // replace with a valid username

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Authentication failure detected!");
            } else {
                System.out.println("Authentication successful!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to connect to the database: " + e.getMessage());
        }
    }
}