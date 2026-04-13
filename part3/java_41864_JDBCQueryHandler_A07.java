import java.sql.*;

public class java_41864_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "your-username";
    private static final String PASSWORD = "your-password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the SQL statement
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameters for the SQL statement
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            // Step 4: Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("User: " + username + ", Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred while trying to connect to the database or execute the query.");
            e.printStackTrace();
        }
    }
}