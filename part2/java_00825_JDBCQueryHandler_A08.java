import java.sql.*;

public class java_00825_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement for execution
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 3: Set the value of the parameter
            statement.setString(1, "test@example.com");

            // Step 4: Execute the statement
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}