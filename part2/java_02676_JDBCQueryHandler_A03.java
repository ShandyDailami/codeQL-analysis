import java.sql.*;

public class java_02676_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    // SQL queries
    private static final String SQL_QUERY = "SELECT * FROM table";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:your_database", USER, PASSWORD);

            // Step 2: Create a statement object
            statement = connection.createStatement();

            // Step 3: Execute the SQL query
            resultSet = statement.executeQuery(SQL_QUERY);

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection, statement, and result set
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}