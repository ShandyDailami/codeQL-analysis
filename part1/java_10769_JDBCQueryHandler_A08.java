import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_10769_JDBCQueryHandler_A08 {

    // The connection object
    private Connection connection;

    // The statement object
    private PreparedStatement statement;

    // The result set object
    private ResultSet resultSet;

    // The database URL
    private final String DB_URL = "jdbc:mysql://localhost:3306/db_name";

    // The database credentials
    private final String USER = "root";
    private final String PASSWORD = "password";

    // Constructor
    public java_10769_JDBCQueryHandler_A08() {
        initializeConnection();
    }

    // Method to initialize the connection
    private void initializeConnection() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public void executeQuery(String query) {
        try {
            // Create a statement object
            statement = connection.prepareStatement(query);

            // Execute the statement
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
        }
    }
}