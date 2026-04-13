import java.sql.*;

public class java_32443_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter and execute the statement
            statement.setString(1, "test@example.com");
            ResultSet result = statement.executeQuery();

            // Step 4: Process the result
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}