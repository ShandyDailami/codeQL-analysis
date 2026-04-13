import java.sql.*;

public class java_30364_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_USER = "db_user";
    private static final String DB_PASSWORD = "db_password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_name";

    // Instance of Connection
    private Connection connection;

    // Constructor
    public java_30364_JDBCQueryHandler_A07() {
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public void executeQuery(String query) {
        try {
            // Prepare the statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Process the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        new VanillaJDBCQueryHandler();
    }
}