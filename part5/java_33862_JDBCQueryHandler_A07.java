import java.sql.*;

public class java_33862_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE Username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameter
            preparedStatement.setString(1, "user1");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("Username");
                System.out.println("Username: " + username);
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}