import java.sql.*;

public class java_37490_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameters
            statement.setString(1, "valid_user");

            // Step 4: Execute the statement
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                // Do something with the username and password
            }

            // Step 6: Cleanup
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}