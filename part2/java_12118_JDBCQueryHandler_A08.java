import java.sql.*;

public class java_12118_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM your_table WHERE your_condition");

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handle the result
            while (resultSet.next()) {
                // This is where you handle the result of your query
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC operation: " + e.getMessage());
        }
    }
}