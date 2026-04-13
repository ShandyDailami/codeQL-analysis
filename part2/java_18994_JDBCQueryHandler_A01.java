import java.sql.*;

public class java_18994_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Query to fetch the user information
    private static final String USER_INFO_QUERY = "SELECT * FROM Users WHERE username = ?";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(USER_INFO_QUERY + " 'testUser'");

            // Iterate over the result set
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Do some security sensitive operation here
                // ...

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}