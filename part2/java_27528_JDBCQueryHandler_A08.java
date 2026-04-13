import java.sql.*;

public class java_27528_JDBCQueryHandler_A08 {
    // Data source name (URL)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Establish a connection to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database");

            // Step 2: Create a statement object
            statement = connection.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
            System.out.println("Query executed");

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the resources
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure the resources are closed
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}