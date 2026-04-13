import java.sql.*;

public class java_35487_JDBCQueryHandler_A03 {

    // Connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method to execute the query
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Get a connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            // Step 2: Create a statement object
            statement = connection.createStatement();
            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");
            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("Found user: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up the resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}