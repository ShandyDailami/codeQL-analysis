import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_10856_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Step 1: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM my_table WHERE my_column = 'unique_value'");
            
            // Step 2: Handle the result set
            while (resultSet.next()) {
                // Process the result
            }
            
        } catch (SQLException e) {
            // Handle integrity failure
            System.out.println("Integrity failure occurred: " + e.getMessage());
            
        } finally {
            // Step 3: Clean up
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing ResultSet: " + e.getMessage());
                }
            }
            
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing Statement: " + e.getMessage());
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing Connection: " + e.getMessage());
                }
            }
        }
    }
}