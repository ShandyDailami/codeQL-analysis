import java.sql.*;

public class java_06175_JDBCQueryHandler_A08 {
    // Define a private static variable to hold the connection
    private static Connection connection = null;

    // Initialize the connection using a static block
    static {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (Exception e) {
            System.out.println("Error in loading driver");
            e.printStackTrace();
        }
    }

    // Method to execute query
    public static ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // Get a statement object
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error in executing query");
            e.printStackTrace();
        }

        return resultSet;
    }

    // Method to execute update (INSERT, UPDATE, DELETE)
    public static int executeUpdate(String query) {
        Statement statement = null;
        int result = 0;
        try {
            // Get a statement object
            statement = connection.createStatement();

            // Execute the update
            result = statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in executing update");
            e.printStackTrace();
        }

        return result;
    }
}