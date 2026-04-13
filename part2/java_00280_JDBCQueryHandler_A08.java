import java.sql.*;

public class java_00280_JDBCQueryHandler_A08 {
    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "username";
    private String password = "password";

    public void performQuery(String query) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Process the results
            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString("column_name"));
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error occurred while performing the query. " + e.getMessage());
        }
    }
}