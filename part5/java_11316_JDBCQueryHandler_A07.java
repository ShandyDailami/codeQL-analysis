import java.sql.*;

public class java_11316_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Retrieve the user's password from the database
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "user");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");

                // Check if the user's password matches the provided input
                if (dbPassword.equals(password)) {
                    System.out.println("Authentication successful");
                } else {
                    System.out.println("Authentication failure");
                }
            } else {
                System.out.println("User not found in the database");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}