import java.sql.*;

public class java_04519_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String selectQuery = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                // Process the data here
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}