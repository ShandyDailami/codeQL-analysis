import java.sql.*;

public class java_00297_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 3: Set the parameter value
            preparedStatement.setString(1, "admin");

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();
            System.out.println("Connection closed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}