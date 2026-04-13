import java.sql.*;

public class java_34167_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // Connect to the database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Check if the user exists
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, "user1"); // Replace with actual username
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // User found, proceed with authentication
                String dbPassword = resultSet.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}