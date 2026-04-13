import java.sql.*;

public class java_16455_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Open a connection
            statement = connection.createStatement();

            // Step 3: Execute SQL query
            String sql = "UPDATE test_table SET id = null WHERE id = '1'";
            int rowsUpdated = statement.executeUpdate(sql);

            // Step 4: Process the results
            if (rowsUpdated > 0) {
                System.out.println("Updated " + rowsUpdated + " rows.");
            } else {
                System.out.println("No rows updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
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