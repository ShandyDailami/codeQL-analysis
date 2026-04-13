import java.sql.*;

public class java_08006_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:your_database_url";
    private static final String user = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

            // Step 2: Execute a query
            String query = "SELECT * FROM your_table WHERE condition";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 3: Process the results
            while (resultSet.next()) {
                // Process each result
                String column1 = resultSet.getString("column1");
                // ...
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Disconnected from database");

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting or executing query: " + e);
        }
    }
}