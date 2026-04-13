import java.sql.*;

public class java_19446_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:your_db_url";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Setting the parameter here is crucial for security
            preparedStatement.setString(1, "attacker_username");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                System.out.println("Found user: " + dbUsername);
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}