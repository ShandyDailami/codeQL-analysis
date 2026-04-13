import java.sql.*;

public class java_39982_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a SQL statement
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters
            preparedStatement.setString(1, "username");
            preparedStatement.setString(2, "password");

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if (username.equals(dbUsername) && password.equals(dbPassword)) {
                    System.out.println("User authenticated successfully");
                } else {
                    System.out.println("Authentication failed");
                }
            }

            // Step 6: Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}