import java.sql.*;

public class java_33980_JDBCQueryHandler_A08 {

    // Define the database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // Define the SQL query to be executed
    private static final String QUERY = "SELECT * FROM table";

    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Prepare the statement for execution
            Statement statement = connection.createStatement();

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(QUERY);

            // Process the result set
            while (resultSet.next()) {
                // Process each row of the result set
                System.out.println("Row: " + resultSet.getString("field"));
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBCQueryHandler: " + e.getMessage());
        }
    }
}