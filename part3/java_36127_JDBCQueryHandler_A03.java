import java.sql.*;

public class java_36127_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters
            preparedStatement.setString(1, "Test User");
            preparedStatement.setString(2, "testuser@example.com");

            // Step 3: Execute the statement
            preparedStatement.executeUpdate();

            // Step 4: Retrieve the user
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM users WHERE name = ?");
            if (resultSet.next()) {
                System.out.println("User retrieved: " + resultSet.getString("name"));
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}