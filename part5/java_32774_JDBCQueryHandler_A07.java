import java.sql.*;

public class java_32774_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Your database url
        String username = "myusername"; // Your database username
        String password = "mypassword"; // Your database password

        try {
            // Step 1: Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM users WHERE username = 'testUser' AND password = 'testPassword'"; // Your query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Handle the ResultSet
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}