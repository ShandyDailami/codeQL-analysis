import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12505_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=testdb;user=sa;password=yourpassword";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Create a connection
            connection = DriverManager.getConnection(url);

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            resultSet = statement.executeQuery("SELECT * FROM Users");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID"));
                System.out.println("Name: " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set, statement and connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}