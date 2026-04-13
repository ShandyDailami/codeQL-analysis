import java.sql.*;

public class java_22287_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement for execution (e.g., SELECT, INSERT, UPDATE, DELETE)
            Statement statement = connection.createStatement();

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'admin'");

            // Step 4: Process the result set
            while (resultSet.next()) {
                // Assume that the password is hashed
                String hashedPassword = resultSet.getString("password");
                // Compare the hashed password with the input password (e.g., using a hashing function)
                // If they match, then provide access.
                if (hashedPassword.equals(password)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            }

            // Step 5: Clean up resources (e.g., close the statement and connection)
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}