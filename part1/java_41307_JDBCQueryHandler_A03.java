import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_41307_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // for MySQL
            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // for SQL Server
            // Class.forName("com.oracle.jdbc.driver.OracleDriver"); // for Oracle

            // Step 2: Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query
            resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 5: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("your_column_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of their use
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