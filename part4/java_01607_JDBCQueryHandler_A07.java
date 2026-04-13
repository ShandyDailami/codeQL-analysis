import java.sql.*;

public class java_01607_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Set parameter and execute the query
            statement.setString(1, "invalidUser");
            ResultSet result = statement.executeQuery();

            // Step 4: Process the result
            while (result.next()) {
                String user = result.getString("username");
                String password = result.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}