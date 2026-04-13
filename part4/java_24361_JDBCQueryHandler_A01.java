import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24361_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish database connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            connection = DriverManager.getConnection("YOUR_DATABASE_URL");

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            String sqlQuery = "SELECT * FROM YOUR_TABLE_NAME"; // replace YOUR_TABLE_NAME with your actual table name
            resultSet = statement.executeQuery(sqlQuery);

            // Step 4: Process the result
            while (resultSet.next()) {
                System.out.println("Record " + resultSet.getInt("id") + ": " +
                        resultSet.getString("name") + ", " +
                        resultSet.getString("email"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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