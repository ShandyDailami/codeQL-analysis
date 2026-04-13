import java.sql.*;

public class java_30338_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a SQL statement
            String query = "SELECT * FROM Users WHERE password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "password"); // Assume "password" is the input password

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                // Process the username and password
            }

            // Step 6: Clean up the connection
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}