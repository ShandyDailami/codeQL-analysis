import java.sql.*;

public class java_38054_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 1: Establish the connection
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Step 2: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

            // Step 3: Process the results
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                // Process the name (sensitive operation, not shown here)
            }

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the statement (if applicable)
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}