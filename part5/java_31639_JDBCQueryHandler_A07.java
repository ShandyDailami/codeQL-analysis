import java.sql.*;

public class java_31639_JDBCQueryHandler_A07 {

    private static final String USER = "username"; // Replace with your actual username
    private static final String PASSWORD = "password"; // Replace with your actual password
    private static final String URL = "jdbc:your_database_url"; // Replace with your actual database url

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM your_table"; // Replace with your actual table
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the results
            while (resultSet.next()) {
                // Replace these with your actual processing logic
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}