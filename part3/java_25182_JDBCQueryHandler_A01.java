import java.sql.*;

public class java_25182_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "postgres";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Establish the Connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a Statement
            statement = connection.createStatement();

            // Step 3: Execute a SQL Query
            String sql = "SELECT * FROM users"; // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // process the data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the Connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}