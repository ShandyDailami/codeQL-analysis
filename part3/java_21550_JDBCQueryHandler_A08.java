import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21550_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 2: Execute a SQL query
        String query = "SELECT * FROM your_table";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
            // Step 3: Handle the ResultSet (Optional)
            while (resultSet.next()) {
                // ...
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close resources
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