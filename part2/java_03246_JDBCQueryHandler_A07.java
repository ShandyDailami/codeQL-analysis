import java.sql.*;

public class java_03246_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'user' AND password = 'password'");

            // Step 4: Handle the result set
            while (resultSet.next()) {
                // Extract data from the result set
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Perform authentication operation here
                if (username.equals("user") && password.equals("password")) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}