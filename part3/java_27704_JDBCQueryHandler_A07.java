import java.sql.*;

public class java_27704_JDBCQueryHandler_A07 {

    // Step 1: Define the database connection string
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    // Step 2: Implement the query
    public void handleQuery(String query) {
        try {
            // Step 3: Establish the connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 4: Prepare the statement
            Statement statement = connection.createStatement();

            // Step 5: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 6: Process the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // ... handle password in a secure way
            }

            // Step 7: Clean up
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}