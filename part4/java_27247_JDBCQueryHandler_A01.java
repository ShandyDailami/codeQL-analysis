import java.sql.*;

public class java_27247_JDBCQueryHandler_A01 {

    // Step 1: Create a Connection Object
    private static Connection connection = null;

    // Step 2: Use static block for the initialization of connection
    static {
        try {
            // Step 2.1: Load the Database Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2.2: Establish the Connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Step 3: Implement methods for database operations
    public static ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 3.1: Create a Statement Object
            statement = connection.createStatement();

            // Step 3.2: Execute the Query
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3.3: Return the ResultSet
        return resultSet;
    }

    // Example usage:
    public static void main(String[] args) {
        String query = "SELECT * FROM users";
        ResultSet resultSet = executeQuery(query);

        // ... handle resultSet (you can use it in a loop, print it, etc)
    }
}