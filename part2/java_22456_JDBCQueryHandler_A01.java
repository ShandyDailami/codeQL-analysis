import java.sql.*;

public class java_22456_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the SQL statement
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set the parameter value
            statement.setString(1, "admin");

            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 5: Process the results
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}