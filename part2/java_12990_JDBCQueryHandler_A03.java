import java.sql.*;

public class java_12990_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the SQL query
            String query = "SELECT * FROM my_table";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the results
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ... process the results
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}