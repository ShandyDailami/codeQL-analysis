import java.sql.*;

public class java_36309_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // The database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/database";

    // The SQL query
    private static final String SQL_QUERY = "SELECT * FROM table";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2: Execute the SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            // Step 3: Process the result set
            while (resultSet.next()) {
                // Extract and print the result
                System.out.println(resultSet.getString("column_name"));
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        }
    }
}