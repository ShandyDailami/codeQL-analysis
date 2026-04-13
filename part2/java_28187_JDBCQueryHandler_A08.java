import java.sql.*;

public class java_28187_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:your_database_url";
    private static final String username = "your_username";
    private static final String password = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String selectQuery = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Step 4: Handle the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Handle id and name here
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}