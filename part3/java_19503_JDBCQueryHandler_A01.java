import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19503_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the driver for SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Step 2: Establish a connection
            String url = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName";
            String username = "username";
            String password = "password";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query
            String query = "SELECT * FROM YourTableName";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                // Add more processing code here
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}