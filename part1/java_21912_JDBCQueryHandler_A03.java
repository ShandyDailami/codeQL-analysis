import java.sql.*;

public class java_21912_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Define your database credentials
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 2: Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Define your query
            String query = "SELECT sensitive_data FROM sensitive_table";

            // Step 4: Prepare your statement
            Statement statement = connection.createStatement();

            // Step 5: Execute your query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 6: Process the results
            while (resultSet.next()) {
                String sensitiveData = resultSet.getString("sensitive_data");
                // Perform security-sensitive operations with sensitiveData...
            }

            // Step 7: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}