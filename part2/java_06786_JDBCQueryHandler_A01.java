import java.sql.*;

public class java_06786_JDBCQueryHandler_A01 {
    // Create a variable for the URL and user credentials
    private static final String DATABASE_URL = "your_database_url";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Step 2: Create a statement object
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the result set
            while (resultSet.next()) {
                // This is a placeholder. In a real application, you would replace this with code to handle the result set.
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // ... and so on
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