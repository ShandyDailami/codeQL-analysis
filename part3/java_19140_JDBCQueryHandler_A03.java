import java.sql.*;

public class java_19140_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/db_name";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM table_name"; // replace with your query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("column_name")); // replace with your column names
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